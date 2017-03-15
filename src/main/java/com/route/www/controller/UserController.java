package com.route.www.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.route.www.common.Role;
import com.route.www.domain.User;
import com.route.www.service.UserDetailsServiceImpl;
import com.route.www.service.UserService;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public <T> Map<String, T> signin(User newUser) {
		Map<String, T> resp = new HashMap<>();
		User returnUser = null;
		try {
			newUser.setRole(Role.PARTICIPANT);
			if (userService.findByUsername(newUser.getUsername()) != null) {
				resp.put("message", (T) "User name already exists");
				resp.put("code", (T) new Integer(1));
			} else {
				returnUser = userDetailsService.saveUser(newUser);
				resp.put("user", (T) returnUser);
				resp.put("message", (T) "registration success");
				resp.put("code", (T) new Integer(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.put("message", (T) "registration error, Server error.");
			LOG.debug("registration error: " + e.getMessage());
			resp.put("code", (T) new Integer(-1));
		}
		return resp;
	}
	@GetMapping("/save")
	public <T> Map<String, T> save() {
		Map<String, T> resp = new HashMap<>();
		User returnUser = null;
		User newUser = new User();
		newUser.setUsername("cbtpro");
		newUser.setPassword("090712");
		newUser.setRealName("陈碧滔");
		newUser.setSex(1);
		newUser.setRole(Role.PARTICIPANT);
		newUser.setTel("18916163020");
		User u = userService.findByUsername(newUser.getUsername());
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

	@GetMapping("/findByUserName")
	public User findByUserName(@RequestParam("userName") String userName) {
		User user = userService.findByUsername(userName);
		return user;
	}
}
