package com.example.democonfiglocal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class DemoConfigLocalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoConfigLocalApplication.class, args);
	}

}
