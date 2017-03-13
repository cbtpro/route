package com.route.www.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public <T> Map<String, T> save() {
		Map<String, T> resp = new HashMap<>();
		User returnUser = null;
		User newUser = new User();
		newUser.setUserName("陈碧滔");
		newUser.setSex(1);
		newUser.setRole(Role.PARTICIPANT);
		newUser.setTel("18916163020");
		User u = userService.findByUserName(newUser.getUserName());
		if(u == null) {
			returnUser = userService.save(newUser);
			resp.put("user", (T) returnUser);
			resp.put("code", (T) new Integer(0));
		} else {
			resp.put("code", (T) new Integer(1));
		}
		return resp;
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
