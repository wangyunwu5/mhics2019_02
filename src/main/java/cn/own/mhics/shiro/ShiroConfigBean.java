package cn.own.mhics.shiro;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.own.mhics.cache.CustomCacheManager;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;
 
/**
 * Shiro配置Bean
 */
@Configuration
public class ShiroConfigBean {
 
	/**
	 * 添加自己的过滤器，自定义url规则
	 * Shiro自带拦截器配置规则
	 * @param securityManager
	 * @return
	 */
	@Bean("shiroFilter")
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		//添加自己的过滤器取名为jwt
		Map<String,Filter> filterMap = new HashMap<>(16);//数组长度为16
		filterMap.put("jwt",new JwtFilter());
		shiroFilterFactoryBean.setFilters(filterMap);
		// 必须设置 SecurityManager
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 拦截器.
		LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>(16);
		filterChainDefinitionMap.put("/**", "jwt");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}
 
	/**
	 * 配置使用自定义Realm,关闭Shiro自带的session
	 * @param myShiroMealm
	 * @return
	 */
	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")//告诉编译器忽略指定的警告，不用在编译完成后出现警告信息。
	@Bean
	public DefaultWebSecurityManager securityManager(MyShiroRealm myShiroMealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 注入自定义的realm;
		securityManager.setRealm(myShiroMealm);
		//关闭shiro自带的session
		DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
		DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
		defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
		subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
		securityManager.setSubjectDAO(subjectDAO);
		
		//设置自定义cache缓存
		securityManager.setCacheManager(new CustomCacheManager());
		
		return securityManager;
	}
 
	/*
	 * 开启shiro aop注解支持 使用代理方式;所以需要开启代码支持;
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
			DefaultWebSecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
	/**
	 * DefaultAdvisorAutoProxyCreator，Spring的一个bean，由Advisor决定对哪些类的方法进行AOP代理。
	 */
	@Bean
	@ConditionalOnMissingBean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator defaultAAPC = new DefaultAdvisorAutoProxyCreator();
		defaultAAPC.setProxyTargetClass(true);
		return defaultAAPC;
	}
	 @Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
	     return new LifecycleBeanPostProcessor();
	}
}
