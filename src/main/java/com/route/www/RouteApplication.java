package com.route.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.route.www.util.SFTPSetting;

@SpringBootApplication
//@EnableScheduling  //默认其实就是启用的,所以可以注释掉他
@EnableConfigurationProperties({SFTPSetting.class})
public class RouteApplication {
	public static void main(String[] args) {
		SpringApplication.run(RouteApplication.class, args);
	}
}
