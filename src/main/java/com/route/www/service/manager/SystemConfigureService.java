package com.route.www.service.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.route.www.domain.system.SystemConfigure;

@Service
public interface SystemConfigureService {

	public List<SystemConfigure> findAll();
	
	public SystemConfigure save(SystemConfigure config);
	
	public List<SystemConfigure> findBySystemConfigureName(String name);
	
	public SystemConfigure findBySystemConfigId(String id);
}
