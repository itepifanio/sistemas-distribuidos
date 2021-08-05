package com.example.distribuida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = { "com.example.distribuida.entity" })
@ComponentScan(basePackages = {"com.example.distribuida.controller"})
public class DistribuidaApplication {

	public static void main(String[] args) {
		SpringApplication.run(
				DistribuidaApplication.class, args
		);
	}
}
