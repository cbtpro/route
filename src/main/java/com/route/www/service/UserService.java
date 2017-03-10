package com.route.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.route.www.domain.User;
import com.route.www.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
}
