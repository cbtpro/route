package com.route.www.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.route.www.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, String> {
	
	List<User> findByTel(String tel);
}
