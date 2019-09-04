package com.hyxy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hyxy.utils.LanJieQi;
//@Configuration
public class LanJieQiConfig implements  WebMvcConfigurer{
	@Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      // addPathPatterns 用于添加拦截规则
	      // excludePathPatterns 用于排除拦截
	      InterceptorRegistration addInterceptor = registry.addInterceptor(new LanJieQi());
	      // 排除配置,排除所有静态文件和不拦截的路径
              addInterceptor.addPathPatterns("/**"); // 过滤全部请求
	      // 排除配置,排除所有静态文件
	     
	      addInterceptor.excludePathPatterns("/**/*.jpg","/**/*.png");
	      addInterceptor.excludePathPatterns("/logincontroller/login","/indexcontroller/home","/css/**","/font/**","/images/**","/img/**","/js/**","/login.jsp");
	   }
}
