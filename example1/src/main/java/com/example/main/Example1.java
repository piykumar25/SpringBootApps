package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle veh = context.getBean("audiVehicle",Vehicle.class);
        /*
        We don't need to do any explicit casting while fetching a bean from context.
         */
        System.out.println("Vehicle name from Spring Context is: " + veh.getName());

        // To avoid NoUniqueBeanDefinitionException need to give spring bean context name as parameter

        var veh2 = context.getBean("ferrariVehicle", Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + veh2.getName());


        String hello = context.getBean(String.class);
        System.out.println("String value from Spring Context is: " + hello);

        Integer num = context.getBean(Integer.class);
        System.out.println("Integer value from Spring Context is: " + num);

    }
}
