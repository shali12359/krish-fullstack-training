package com.prabath.rentcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.prabath.rentcloud.model.customer")
public class DemoCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCustomerServiceApplication.class, args);
	}

}
