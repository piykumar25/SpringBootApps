package com.coder.example12;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class Example12Application {

	public static void main(String[] args) {
		SpringApplication.run(Example12Application.class, args);
	}

}
