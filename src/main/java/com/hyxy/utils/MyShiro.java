package com.hyxy.utils;

import java.util.Arrays;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyxy.entity.User;
import com.hyxy.service.LoginService;

public class MyShiro extends AuthorizingRealm{
   @Autowired
   private LoginService LoginService;
   //权限和角色拦截
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取用户名
		String username=(String) principals.getPrimaryPrincipal(); 
		  // 获取到当前登录用户的认证信息
	      SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		//设置角色
		  authorizationInfo.setRoles(LoginService.getrole(username));
		//设置权限
		
		 
		authorizationInfo.setStringPermissions(LoginService.getPermission(username));
		return authorizationInfo;
	}
  //登录验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String  username=(String)token.getPrincipal();
        User user =LoginService.selectu(username);
        if (user!=null) {
        	 // 从数据库获取到用户名和密码，会和提交的用户名密码进行比较,不匹配会报错
        	AuthenticationInfo aInfo=new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),"");
			return aInfo;
		}else {
			return null;
		}
		
	}

}
