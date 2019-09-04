package com.hyxy.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("quitcontroller")

public class Quit {

	@RequestMapping("quit")
	public String Index(HttpServletRequest request) {
		/*
		 * request.getSession().removeAttribute("user"); return "redirect:/login.jsp";
		 */
		 // subject的实现类DelegatingSubject的logout方法，将本subject对象的session清空了
	      Subject subject = SecurityUtils.getSubject();
	      subject.logout();
	      return "redirect:/login.jsp";

	}
	
}
