package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name = "Lucy";

    /*
        The @Autowired annotation marks on a field, constructor, Setter method
        is used to auto-wired the beans that is 'injecting beans'(Objects) at runtime
        by Spring Dependency Injection mechanism
     */

//    @Autowired
    private final Vehicle vehicle;

    @Autowired
    public Person(@Qualifier("vehicle") Vehicle vehicle) {
        System.out.println("Person been created by Spring");
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

//    @Autowired
//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }
}
