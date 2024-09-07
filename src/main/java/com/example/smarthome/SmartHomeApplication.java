package com.example.smarthome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SmartHomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartHomeApplication.class, args);
    }
}


//Enable turn on/off for individual appliance
//Springboot testing
// Add properties spring.port
//Add class and method level comments
//Add application context using spring property in application.properties
//Add general logging 
//Add success or error messages for turnOn and turnOff commands
//Enable scheduling - restart of appliances