package com.fuelapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@EnableConfigurationProperties
@EntityScan(basePackages = "com.fuelapp.models")
public class FuelappInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuelappInventoryServiceApplication.class, args);
	}

}
