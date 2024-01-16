package com.example.main;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import com.example.services.VehicleServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example7 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        VehicleServices vehicleServices1 = context.getBean(VehicleServices.class);
        VehicleServices vehicleServices2 = context.getBean("vehicleServices",VehicleServices.class);
        System.out.println("Hashcode of the object VehicleServices1 : " + vehicleServices1.hashCode());
        System.out.println("Hashcode of the object VehicleServices1 : " + vehicleServices2.hashCode());
        if(vehicleServices1 == vehicleServices2) {
            System.out.println("VehicleServices bean is a singelton scoped bean");
        } else {
            System.out.println("VehicleServices bean is a prototype scoped bean");
        }

    }
}
