package com.hyxy.config;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hyxy.utils.MyShiro;

@Configuration
public class MyShiroConfig {
	
	@Bean
	   public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		  ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
	      shiroFilterFactoryBean.setSecurityManager(securityManager);
	      //未登录跳转到的页面或url，如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
           shiroFilterFactoryBean.setLoginUrl("/login.jsp");
           //未授权跳转到的页面或url
       

           // 添加shiro内置过滤器
           Map<String, String> map = new LinkedHashMap<String, String>();
           // 配置不需要验证过滤器
//           map.put("/", "anon");
           map.put("/logincontroller/login", "anon");
           map.put("/css/**", "anon");
           map.put("/js/**", "anon");
           map.put("/img/**", "anon");
           map.put("/font/**", "anon");
           map.put("/images/**", "anon");
           map.put("/img/**", "anon");
           // 保证除定义url外的所有url都必须是已登录的
           map.put("/**", "user");
           shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
           return shiroFilterFactoryBean;

	}
	@Bean
	public MyShiro myShiro() {
		MyShiro myShiro=new MyShiro();
		return myShiro;
	}
   
	@Bean 
	   public SecurityManager securityManager() {
		 DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
	        // 设置自定义realm,不能直接 new必须要使用 @Bean 注入 MyRealm， 
	        securityManager.setRealm(myShiro());
	        return securityManager;

	
	}
}
