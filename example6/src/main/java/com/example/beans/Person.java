package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component(value = "personBean")
@Lazy
public class Person {

    private String name = "Lucy";

    @Autowired
    public Person() {
        System.out.println("Person been created by Spring");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
