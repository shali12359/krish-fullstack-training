package com.prabath.rentcloud.vehicleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.prabath.rentcloud.model.vehicle")
public class DemoVehicleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoVehicleServiceApplication.class, args);
	}

}
