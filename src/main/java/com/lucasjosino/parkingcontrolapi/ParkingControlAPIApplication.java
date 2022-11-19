package com.lucasjosino.parkingcontrolapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories()
public class ParkingControlAPIApplication {
	public static void main(String[] args) {
		SpringApplication.run(ParkingControlAPIApplication.class, args);
	}
}
