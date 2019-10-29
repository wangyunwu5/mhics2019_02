package cn.own.mhics.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.own.mhics.common.Constant;
import cn.own.mhics.entity.Person;
import cn.own.mhics.entity.Resource;
import cn.own.mhics.entity.Role;
import cn.own.mhics.server.UserService;
import cn.own.mhics.tools.JedisUtil;
import cn.own.mhics.tools.StringUtil;

import java.util.List;
/**
 * realm实现类,用于实现具体的验证和授权方法
 * @author Bean
 *
 */
@Service
public class MyShiroRealm extends AuthorizingRealm {
 
	
	@Autowired
	private UserService userService;
	
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
		
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

		String account = JwtUtil.getClaim(principals.toString(),Constant.ACCOUNT);
		List<Role> roles = userService.getRoleByAccount(account);
		for (Role role : roles) {
			if(role != null) {
				simpleAuthorizationInfo.addRole(role.getRoName());
				List<Resource> resources = userService.getResourceByRole(role.getRoleId());
				for (Resource resource : resources) {
					if(resource != null) {
						simpleAuthorizationInfo.addStringPermission(resource.getReCode());
					}
				}
			}
		}
		return simpleAuthorizationInfo;
	}
 
}
