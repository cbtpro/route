package com.route.www.repository.manager;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.route.www.domain.system.SystemConfigure;

@Repository
public interface SystemConfigureRepository extends MongoRepository<SystemConfigure, ObjectId> {

	List<SystemConfigure> findByConfigName(String name);
	
	SystemConfigure findById(String id);
}
