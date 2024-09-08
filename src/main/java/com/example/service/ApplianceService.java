package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for controlling smart home appliances.
 */
@Service
public class ApplianceService {

    
    private final List<Appliance> appliances;
    

    /**
     * Constructor for SmartHomeController.
     * @param appliances List of appliances to be managed.
     */
    
     @Autowired
    public ApplianceService(List<Appliance> appliances) {
        this.appliances = appliances;
    }

    /**
     * Turns on an individual appliance by ID.
     * @param id The ID of the appliance.
     * @return Success message if appliance is found and turned on, otherwise an error message.
     */
    public String turnOnAppliance(String id) {
        Optional<Appliance> appliance = appliances.stream()
            .filter(a -> a.getId().equals(id))
            .findFirst();

        if (appliance.isPresent()) {
            appliance.get().turnOn();
            return "Appliance with ID " + id + " turned on.";
        } else {
            return "Appliance not found.";
        }
    }

    /**
     * Turns off an individual appliance by ID.
     * @param id The ID of the appliance.
     * @return Success message if appliance is found and turned off, otherwise an error message.
     */
    public String turnOffAppliance(String id) {
        Optional<Appliance> appliance = appliances.stream()
            .filter(a -> a.getId().equals(id))
            .findFirst();

        if (appliance.isPresent()) {
            appliance.get().turnOff();
            return "Appliance with ID " + id + " turned off.";
        } else {
            return "Appliance not found.";
        }
    }

    /**
     * Increases the fan speed of a specific appliance by a given increment value.
     * @param id The ID of the appliance.
     * @param incrementValue The value by which the fan speed should be increased.
     * @return Success message if appliance is found and speed is increased, otherwise an error message.
     */
    public String increaseFanSpeed(String id, int incrementValue) {
        Optional<Appliance> appliance = appliances.stream()
            .filter(a -> a.getId().equals(id))
            .findFirst();

        if (appliance.isPresent()) {
            Appliance foundAppliance = appliance.get();

            if (foundAppliance instanceof Fan) {
                if (incrementValue == 0) { return "Fan with ID " + id + " is turned off (speed set to 0)."; }

                ((Fan) foundAppliance).increaseFanSpeed(incrementValue);
                return "Increased fan speed of appliance with ID " + id + " by " + incrementValue + ".";
            } else {
                return "Appliance with ID " + id + " does not support fan speed adjustments.";
            }
        } else {
            return "Appliance not found.";
        }
    }

    /**
     * Scheduled task to turn off all appliances for an annual update.
     */
    @Scheduled(cron = "0 0 1 1 1 *") // Runs every January 1st at 1:00 AM
    public void performAnnualUpdate() {
        System.out.println("Performing annual update.");
        turnAllOff();
    }

    private void turnAllOff() {
        for (Appliance appliance : appliances) {
            appliance.turnOff();
        }
        System.out.println("All appliances are turned off.");
    }
}
