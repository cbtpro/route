package com.route.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.route.www.common.Role;
import com.route.www.domain.User;
import com.route.www.service.UserService;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/save")
	public User save() {
		User user = new User();
		user.setUserName("陈碧滔");
		user.setSex(1);
		user.setRole(Role.PARTICIPANT);
		user.setTel("18916163020");
		userService.save(user);
		return user;
	}

	@GetMapping("/findAll")
	public List<User> findAll() {
		List<User> userList = userService.findAll();
		return userList;
	}

	@GetMapping("/findByName")
	public User findByName(@RequestParam("userName") String userName) {
		User user = userService.findByUserName(userName);
		return user;
	}
}
