package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.service.AirConditioner;
import com.example.service.Appliance;
import com.example.service.Fan;
import com.example.service.Light;

import java.util.Arrays;
import java.util.List;

/**
 * Configuration class for setting up the smart home application.
 */
@Configuration
public class SmartHomeConfig {

    /**
     * Creates a list of appliances to be managed.
     * @return A list of appliances.
     */
    @Bean
    public List<Appliance> appliances() {
        // Example appliances
        Fan fan1 = new Fan("fan1");
        Fan fan2 = new Fan("fan2");
        AirConditioner ac1 = new AirConditioner("ac1");
        Light light1 = new Light("light1");

        return Arrays.asList(fan1, fan2, ac1, light1);
    }

    /**
     * Creates a SmartHomeController bean with the list of appliances.
     * @return A SmartHomeController instance.
     */
    /**@Bean
    public SmartHomeController smartHomeController(List<Appliance> appliances) {
        return new SmartHomeController(appliances);
    }*/
}
