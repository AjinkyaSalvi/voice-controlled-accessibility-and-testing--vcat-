package com.mavs.uta.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.mavs.uta.service"})
public class VcatServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VcatServiceApplication.class, args);
		
	}

}

