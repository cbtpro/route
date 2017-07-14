package com.route.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.route.www.util.SFTPSetting;

@SpringBootApplication
//@EnableScheduling  //默认其实就是启用的,所以可以注释掉他
@EnableConfigurationProperties({SFTPSetting.class})
public class RouteApplication {
	public static void main(String[] args) {
		SpringApplication.run(RouteApplication.class, args);
	}
	
//	@Bean
//	public EmbeddedServletContainerFactory servletContainer() {
//
//		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
//			@Override
//			protected void postProcessContext(Context context) {
//				SecurityConstraint securityConstraint = new SecurityConstraint();
//				securityConstraint.setUserConstraint("CONFIDENTIAL");
//				SecurityCollection collection = new SecurityCollection();
//				collection.addPattern("/*");
//				securityConstraint.addCollection(collection);
//				context.addConstraint(securityConstraint);
//			}
//		};
//		tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
//		return tomcat;
//	}
//
//	private Connector initiateHttpConnector() {
//		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//		connector.setScheme("http");
//		connector.setPort(8080);
//		connector.setSecure(false);
//		connector.setRedirectPort(8443);
//		return connector;
//	}
}
