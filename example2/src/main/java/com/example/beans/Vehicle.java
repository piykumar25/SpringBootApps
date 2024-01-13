package com.example.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @PostConstruct // instructs spring to execute that method after it finishes creating the bean
//    public void initialize() {
//        this.name = "Tata motors ";
//    }
//
//    @PreDestroy
//    public void destroy() {
//        System.out.println("Destroying Vehicle bean");
//    }

    public void printHello() {
        System.out.println("Printing Hello from component Vehicle Bean");
    }
}
