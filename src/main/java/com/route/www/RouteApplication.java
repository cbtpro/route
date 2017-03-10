package com.route.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({SFTPSetting.class})
public class RouteApplication {
	public static void main(String[] args) {
		SpringApplication.run(RouteApplication.class, args);
	}
}
