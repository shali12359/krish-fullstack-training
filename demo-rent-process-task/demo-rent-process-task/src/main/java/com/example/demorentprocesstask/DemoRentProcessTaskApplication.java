package com.example.demorentprocesstask;

import com.example.demorentprocesstask.service.RentProcessTaskRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class DemoRentProcessTaskApplication {
	@Bean
	RentProcessTaskRunner getRentProcessTaskRunner() {
		return new RentProcessTaskRunner();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoRentProcessTaskApplication.class, args);
	}

}
