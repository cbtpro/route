package com.route.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.route.www.common.Role;
import com.route.www.domain.User;
import com.route.www.service.UserService;

@RestController
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

	@GetMapping("/find")
	public List<User> find() {
		List<User> userList = userService.findAll();
		return userList;
	}

	@GetMapping("/findByName")
	public User findByName(@RequestParam("userName") String userName) {
		User user = userService.findByUserName(userName);
		return user;
	}
}
