package com.route.www.service.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.route.www.domain.system.SystemConfigure;
import com.route.www.repository.manager.SystemConfigureRepository;
import com.route.www.service.manager.SystemConfigureService;

@Component
public class SystemConfigureServiceImpl implements SystemConfigureService {

	@Autowired
	private SystemConfigureRepository sysConfigRepo;

	@Override
	public List<SystemConfigure> findAll() {
		return sysConfigRepo.findAll();
	}

	@Override
	public SystemConfigure save(SystemConfigure config) {
		return sysConfigRepo.save(config);
	}

	@Override
	public List<SystemConfigure> findBySystemConfigureName(String name) {
		return sysConfigRepo.findByConfigName(name);
	}

	@Override
	public SystemConfigure findBySystemConfigId(String id) {
		return sysConfigRepo.findById(id);
	}
}
