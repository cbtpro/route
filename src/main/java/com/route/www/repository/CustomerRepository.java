package com.route.www.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.route.www.domain.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	public Customer findByUserName(String firstName);
	
	public List<Customer> findByTel(String tel);
}
