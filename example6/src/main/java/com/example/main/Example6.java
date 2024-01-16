package com.example.main;

import com.example.beans.Person;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example6 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        System.out.println("Before retrieving the person bean from the spring Context");
        Person person = context.getBean(Person.class);
        System.out.println("After retrieving the Person bean from the spring Context");
    }
}
