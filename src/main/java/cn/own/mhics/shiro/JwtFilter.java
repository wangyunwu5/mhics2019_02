package cn.own.mhics.shiro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;

import cn.own.mhics.common.Constant;
import cn.own.mhics.common.ResponseBean;
import cn.own.mhics.exception.CustomException;
import cn.own.mhics.tools.JedisUtil;
import cn.own.mhics.tools.JsonConvertUtil;
import cn.own.mhics.tools.PropertiesUtil;

public class JwtFilter extends BasicHttpAuthenticationFilter{
	
	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		// TODO Auto-generated method stub
		//查看当前Header中是否携带Authorization属性(token)，有的话就进行登录认证授权
		if(this.isLoginAttempt(request,response)) {
			//已经携带了Token
			try {
				//进行shiro的登录user
				this.executeLogin(request,response);
				
			}catch(Exception e) {
				//认证出现异常，将错误信息传给msg
				String msg = e.getMessage();
				//获取应用异常（该cause是导致抛出此throwable的throwable）
				Throwable throwable= e.getCause();
				if(throwable instanceof SignatureVerificationException) {
					//该异常为JWT的AccessToken认证失败(Token或者密钥不正确)
					msg = "Token或者密钥不正确（"+throwable.getMessage()+")";
				}
				else if(throwable instanceof TokenExpiredException) {
					//该异常为JWT的AccessToken已过期，判断RefreshToken未过期就进行AccessToken刷新
					if(this.refreshToken(request,response)) {
						return true;
					}
					else {
						msg = "Token已过期("+throwable.getMessage()+")";
					}
				}
				else {
					//应用异常不为空
					if(throwable != null)
						msg = throwable.getMessage();
				}
				//Token 认证失败直接返回Response信息
				this.response401(response,msg);
				return false;
			}
		}
		else {
			//没有携带Token
			HttpServletRequest httpServletRequest = WebUtils.toHttp(request);//WebUtils工具把ServletRequest转换为HttpServletRequest
			//获取当前请求类型
			String httpMethod  = httpServletRequest.getMethod();
			//获取当前请求URI
			String requestURI = httpServletRequest.getRequestURI();
			logger.info("当前请求{}Authorization属性(Token)为空 请求类型{}",requestURI,httpMethod);
			//mustLoginFlag = true 开启任何请求必须先登录才可访问
			Boolean mustLoginFlag = false;
			if(mustLoginFlag) {
				this.response401(response,"请先登录");
				return false;
			}
		}
		
		return true;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		this.sendChallenge(request,response);
		return false;
	}

	/**
	 * 判断用户是否想要登入
	 * 检测Header里面是否包含Authorizaation字段，有就进行Token登录认证授权
	 */
	@Override
	protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
		String token = this.getAuthzHeader(request);
		return token != null && token.equals("");
	}
	/**
	 * 进行AccessToken登录认证授权
	 */
	@Override
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
		//拿到当前Header中Authorization的AccessToken(shiro中的getAuthzHeader()方法已经实现)
		JwtToken token = new JwtToken(this.getAuthzHeader(request));
		//提交给MyShiroRealm进行认证，如果错误他会抛出异常并捕获
		this.getSubject(request,response).login(token);
		//如果没有抛出异常则代表登入成功，返回true
		return true;
	}
	/**
	 * 对跨域提供支持
	 */
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
		HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
		//httpServletResponse.setHeader("Access-control-Allow-Origin","*");这种方式允许所有域名都可以访问，并不安全，
		httpServletResponse.setHeader("Access-control-Allow-Origin",httpServletRequest.getHeader("Origin"));
		httpServletResponse.setHeader("Access-Control-Allow-Method","GET,POST,OPTIONS,PUT,DELETE,PATCH");
		httpServletResponse.setHeader("Access-Control-Allow-Headers",httpServletRequest.getHeader("Access-Control-Request-Headers"));
		//跨域是会首先发送一个OPTIONS请求，这里我们给OPTIONS请求直接返回正常状态
		if(httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
			httpServletResponse.setStatus(HttpStatus.OK.value());
			return false;
		}
		return super.preHandle(request, response);
	}

	/**
	 * 此处为AccessToken刷新，进行判断RefreshToken是否过期，未过期就返回新的AccessToken且继续正常访问
	 * @return
	 */
	private boolean refreshToken(ServletRequest request,ServletResponse response) {
		//拿到当前Header中Authorization的AccessToken(shiro中的getAuthzHeader()方法已经实现)
		String token = this.getAuthzHeader(request);
		//获取当前Token的账号信息
		String account = JwtUtil.getClaim(token,Constant.ACCOUNT);
		//判断Redis中RefreshToken是否存在
		if(JedisUtil.exists(Constant.PREFIX_SHIRO_REFRESH_TOKEN +account)) {
			//Redis中RefreshToken还存在，获取RefreshToken的时间戳
			String currentTimeMillisRedis = JedisUtil.getObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN+account).toString();
			if(JwtUtil.getClaim(token,Constant.CURRENT_TIME_MILLIS).equals(currentTimeMillisRedis)) {
				//获取当前最新时间戳
				String currentTimeMillis = String.valueOf(System.currentTimeMillis());
				//读取配置文件，获取refreshTokenExpireTime属性
				PropertiesUtil.readProperties("config.properties");
				String refreshTokenExpireTime = PropertiesUtil.getProperty("refreshTokenExpireTime");
				//设置RefreshToken中的时间戳为当前最新的时间戳，且刷新过期时间重新设置为30分钟过期（配置文件可配置refreshTokenExpireTime属性）
				JedisUtil.setObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN+account,currentTimeMillis,Integer.parseInt(refreshTokenExpireTime));
				//刷新AccessToken,设置时间戳为当前最新时间戳
				token = JwtUtil.sign(account,currentTimeMillis);
				//将新刷新的AccessToken再次进行shiro的登录
				JwtToken jwtToken = new JwtToken(token);
				//提交给MyShiroRealm进行认证，如果错误它会抛出异常并被捕获，如果没有抛出异常则代表登入成功，返回true
				this.getSubject(request,response).login(jwtToken);
				//最后将刷新的AccessToken存放在Response的Header中的Authorization字段返回
				HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
				httpServletResponse.setHeader("Authorization",token);
				httpServletResponse.setHeader("Access-Control-Expose-Headers","Authorization");
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 返回Response 信息
	 */
	private void response401(ServletResponse response,String msg) {
		HttpServletResponse httpServletResponse = WebUtils.toHttp(response);//WebUtils工具把ServletRequest转换为HttpServletRequest
		httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());//401
		httpServletResponse.setCharacterEncoding("UTF-8");
		httpServletResponse.setContentType("application/json;charset=uft-8");
		try(PrintWriter out = httpServletResponse.getWriter()){
			String data = JsonConvertUtil.objectToJson(new ResponseBean(HttpStatus.UNAUTHORIZED.value(),"无权访问(unauthorized):"+msg,null));
			out.append(data);
		}catch(IOException e) {
			throw new CustomException("直接返回Response信息出现IOException异常："+e.getMessage());
		}
	}
}
