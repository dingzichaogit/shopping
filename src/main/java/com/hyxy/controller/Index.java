package com.hyxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("indexcontroller")

public class Index {

	@RequestMapping("index")
	public String Index() {
		return "index";
	}
	@RequestMapping("home")
	public String Home() {
		
		return "home";
	}
}
