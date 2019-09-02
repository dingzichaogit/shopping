package com.hyxy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
   public Map<String, String> Login(@RequestParam Map<String, String> map){
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		List<User> list=loginService.selectuser(map);
		
		 Map<String, String> map1=new HashMap<String, String>();
		 System.out.println(list.size());
		if (list.size()>0) {
			map1.put("message", "成功");
			
		}else {
			map1.put("message", "不成功");
		}
		
		return map1;
	}
	
}
