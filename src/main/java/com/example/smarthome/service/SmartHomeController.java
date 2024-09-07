package com.example.smarthome.service;

import com.example.smarthome.model.Appliance;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartHomeController {

    private final List<Appliance> appliances;

    public SmartHomeController(List<Appliance> appliances) {
        this.appliances = appliances;
    }

    public void turnAllOn() {
        for (Appliance appliance : appliances) {
            appliance.turnOn();
        }
        System.out.println("All appliances are turned on.");
    }

    public void turnAllOff() {
        for (Appliance appliance : appliances) {
            appliance.turnOff();
        }
        System.out.println("All appliances are turned off.");
    }

    // Scheduled task to turn off all appliances for an annual update.
    @Scheduled(cron = "0 0 1 1 1 *") // Runs every January 1st at 1:00 AM
    public void performAnnualUpdate() {
        System.out.println("Performing annual update.");
        turnAllOff();
    }
}
