package com.coderSchool.example11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.coderSchool.example11.proxy")
public class Example11Application {

	public static void main(String[] args) {
		SpringApplication.run(Example11Application.class, args);
	}

}
