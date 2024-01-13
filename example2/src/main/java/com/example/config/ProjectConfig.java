package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
/*
Spring @Configuration annotation is  part of the spring core framework. Spring configuration
annotation indicates that the class has @Bean definition methods. So spring container
can process the class and generate Spring Beans to be used in the application.
 */
@Configuration
@ComponentScan(basePackages = "com.example.beans")
public class ProjectConfig {

}
