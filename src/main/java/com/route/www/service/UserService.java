package com.route.www.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.route.www.domain.User;

@Repository
public interface UserService {

	void save(User user);
	
	User findByUserName(String userName);
	
	List<User> findAll();
}
