package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean(name="audiVehicle")
    Vehicle vehicle() {
        var veh = new Vehicle();
        veh.setName("Audi 8");
        return veh;
    }

    @Primary // Due to this annotation spring context will consider in case of confusion due to multiple beans present of smae type
    @Bean(value = "ferrariVehicle")
    Vehicle vehicle1() {
        var veh = new Vehicle();
        veh.setName("Ferrari");
        return veh;
    }

    @Bean("hondaVehicle")
    Vehicle vehicle2() {
        var veh = new Vehicle();
        veh.setName("Honda");
        return veh;
    }



    @Bean
    String hello() {
        return "Hello World";
    }

    @Bean
    Integer number() {
        return 16;
    }
}
