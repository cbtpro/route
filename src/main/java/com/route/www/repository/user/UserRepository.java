package com.route.www.repository.user;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.route.www.domain.user.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
	
	List<User> findByTel(String tel);
	
	User findByUsername(String username);
}
