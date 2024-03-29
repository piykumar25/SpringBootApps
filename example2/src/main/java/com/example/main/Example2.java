package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example2 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
//        Vehicle veh = context.getBean(Vehicle.class);
//
//        System.out.println("Component Vehicle name from spring context is: " + veh.getName());
//        veh.printHello();
//        context.close();

        Vehicle volkswagen = new Vehicle();
        volkswagen.setName("Volkswagen");
        Supplier<Vehicle> volkswagenSupplier = () -> volkswagen;

        Supplier<Vehicle> audiSupplier = () -> {
            Vehicle audi = new Vehicle();
            audi.setName("Audi");
            return audi;
        };

        Random random = new Random();
        int randomNumber = random.nextInt(10);
        System.out.println("randomNumber = " + randomNumber);

        if((randomNumber % 2 ) == 0) {
            context.registerBean("volkswagen",Vehicle.class,volkswagenSupplier);
        } else {
            context.registerBean("audi",Vehicle.class, audiSupplier);
        }

        Vehicle volksVehicle = null;
        Vehicle audiVehicle = null;

        try {
            volksVehicle = context.getBean("volkswagen", Vehicle.class);
        } catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            System.out.println("Error While creating Volkswagen vehicle");
        }

        try {
            audiVehicle = context.getBean("audi", Vehicle.class);
        } catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            System.out.println("Error While creating Audi vehicle");
        }

        if (null != volksVehicle) {
            System.out.println("Programming Vehicle name from Spring context is: " + volksVehicle.getName());
        } else {
            System.out.println("Programming Vehicle name from Spring context is: " + audiVehicle.getName());
        }


    }
}
