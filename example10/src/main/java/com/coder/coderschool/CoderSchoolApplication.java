package com.coder.coderschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.coder.coderschool.repository")
@EntityScan("com.coder.coderschool.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class CoderSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoderSchoolApplication.class, args);
	}

}
