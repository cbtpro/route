package com.route.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {

	@RequestMapping("user/profile")
	public String userProfile() {
		return "user/profile";
	}
	
	@RequestMapping("aa/goals")
	public String goals() {
		return "user/goals";
	}
	@RequestMapping("success")
	public String ddddd() {
		return "success";
	}
}
