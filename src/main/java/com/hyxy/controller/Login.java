package com.hyxy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyxy.entity.User;
import com.hyxy.service.LoginService;

@Controller
@RequestMapping("logincontroller")
public class Login {
	
@Autowired
  private LoginService loginService;
 
	
	@RequestMapping("login")
	@ResponseBody
   public Map<String, String> Login(@RequestParam Map<String, String> map ,HttpServletRequest request){
		 Map<String, String> map1=new HashMap<String, String>();
		/*
		 * System.out.println(map.get("username"));
		 * System.out.println(map.get("password")); User
		 * user=loginService.selectuser(map); if (user!=null) {
		 * request.getSession().setAttribute("user", user); map1.put("message", "成功");
		 * 
		 * }else { map1.put("message", "不成功"); }
		 */
		 Subject subject =SecurityUtils.getSubject();
		// 把数据名和密码传给自定义的myrealm中的AuthenticationToken token用户登录信息接口
		 UsernamePasswordToken token =new UsernamePasswordToken(map.get("username"),map.get("password"));
		 try {
			 subject.login(token);
			 map1.put("message", "成功");
			 return map1;
		} catch (Exception e) {
			 map1.put("message", "不成功");
			return map1;
			// TODO: handle exception
		}
		 
		 
		
	}
	
	
	@RequestMapping("skip")
	public String Skip() {
		return "power";
	}
}
