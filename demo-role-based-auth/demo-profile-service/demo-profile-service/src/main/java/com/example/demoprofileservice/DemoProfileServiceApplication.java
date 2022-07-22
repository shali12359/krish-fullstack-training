package com.example.demoprofileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EntityScan(basePackages = "com.example.model")
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DemoProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProfileServiceApplication.class, args);
	}

}
