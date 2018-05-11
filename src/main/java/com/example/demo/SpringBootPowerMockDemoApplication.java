package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@SpringBootApplication
//public class SpringBootPowerMockDemoApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringBootPowerMockDemoApplication.class, args);
//	}
//}

// for WebApp
@SpringBootApplication
public class SpringBootPowerMockDemoApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootPowerMockDemoApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootPowerMockDemoApplication.class, args);
	}
}