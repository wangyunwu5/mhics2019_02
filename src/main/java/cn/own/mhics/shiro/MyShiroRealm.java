package cn.own.mhics.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import cn.own.mhics.common.Constant;
import cn.own.mhics.entity.Person;
import cn.own.mhics.server.UserService;
import cn.own.mhics.tools.JedisUtil;
import cn.own.mhics.tools.StringUtil;

import java.util.HashSet;
import java.util.Set;
/**
 * realm实现类,用于实现具体的验证和授权方法
 * @author Bean
 *
 */
public class MyShiroRealm extends AuthorizingRealm {
 
	/**
	 * 用于认证
	 * 进行用户名正确与否验证，
	 */              
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

		String token = (String) authenticationToken.getCredentials();//getCredentials()获取凭据，getPrincipal()获取身份
		//解密获得account,用于和数据库进行对比
		String account = JwtUtil.getClaim(token,Constant.ACCOUNT);
		//账号为空
		if(StringUtil.isBlank(account)) {
			throw new AuthenticationException("Token中账号为空");
		}
		//查询用户是否存在
		UserService userService = new UserService();
		Person user = userService.findOneUserByAccount(account);
		if(user == null) {
			throw new AuthenticationException("该账号不存在");
		}
		//开始认证，要AccessToken认证通过，且Redis中存在RefreshToken，且两个Token时间戳一致
		if(JwtUtil.verify(token) && JedisUtil.exists(Constant.PREFIX_SHIRO_REFRESH_TOKEN+account)) {
			//获取RefreshToken的时间戳
			String currentTimeMillisRedis = JedisUtil.getObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN+account).toString();
			//获取AccessToken时间戳，与RefreshToken时间戳对比
			if(JwtUtil.getClaim(token,Constant.CURRENT_TIME_MILLIS).equals(currentTimeMillisRedis)) {
				return new SimpleAuthenticationInfo(token,token,"myShiroRealm");
			}
		}
		throw new AuthenticationException("Token已过期");
	}
 
	/**
	 *  用于授权(non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
 
		System.out.println("MyShiroRealm的doGetAuthorizationInfo授权方法执行");
 
		// User user=(User)
		// principals.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
		// System.out.println("在MyShiroRealm中AuthorizationInfo（授权）方法中从session中获取的user对象:"+user);
 
		// 从PrincipalCollection中获得用户信息
		Object principal = principals.getPrimaryPrincipal();
		System.out.println("ShiroRealm  AuthorizationInfo:" + principal.toString());
 
		// 根据用户名来查询数据库赋予用户角色,权限（查数据库）
		Set<String> roles = new HashSet<>();
		Set<String> permissions = new HashSet<>();
//		2018.09.14更新
		//		给用户添加user权限 (没有进行判断、对所有的用户给user权限)
		if("user".equals(principal)){
			roles.add("user");
			permissions.add("user:query");
		}
//		当用户名为admin时 为用户添加权限admin  两个admin可以理解为连个字段
		if ("admin".equals(principal)) {
			roles.add("admin");
			permissions.add("admin:query");
		}
//		为用户添加visit游客权限，在url中没有为visit权限，所以，所有的操作都没权限
		if("visit".equals(principal)){
			roles.add("visit");
			permissions.add("visit:query");
		}
//              更新以上代码
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		//添加权限
		info.setStringPermissions(permissions);
		return info;
		// return null;
	}
 
}
