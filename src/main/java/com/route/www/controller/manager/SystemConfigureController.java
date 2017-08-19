package com.route.www.controller.manager;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.route.www.domain.system.SystemConfigure;
import com.route.www.service.manager.impl.SystemConfigureServiceImpl;

@RestController
@RequestMapping(value = "/api/manager", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SystemConfigureController {

	private static final Logger LOG = LoggerFactory.getLogger(SystemConfigureController.class);

	@Autowired
	private SystemConfigureServiceImpl systemConfigureService;

	@RequestMapping(value = "systemConfigure", method = RequestMethod.POST)
	public SystemConfigure addSystemConfigure(@RequestParam(value="config") SystemConfigure config) {
		return systemConfigureService.save(config);
	}
	@RequestMapping(value = "/systemConfigure", method = RequestMethod.GET)
	public List<SystemConfigure> queryAllSystemConfigure() {
		return systemConfigureService.findAll();
	}

	@RequestMapping(value = "/systemConfigfigure/{name}", method = RequestMethod.GET)
	public List<SystemConfigure> queryConfigByName(@RequestParam(value="name", defaultValue="") String name) {
		return systemConfigureService.findBySystemConfigureName(name);
	}
	
	@RequestMapping(value = "/systemConfigfigure/{id}", method = RequestMethod.GET)
	public SystemConfigure queryConfigById(@RequestParam(value="id", defaultValue="") String id) {
		return systemConfigureService.findBySystemConfigId(id);
	}
}
