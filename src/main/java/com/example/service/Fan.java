package com.example.service;

/**
 * Concrete class representing a fan appliance that supports fan speed adjustments.
 */
public class Fan extends Appliance {
    private int fanSpeed;

    public Fan(String id) {
        super(id);
        this.fanSpeed = 0; // Default fan speed
    }

    @Override
    public void turnOn() {
        System.out.println("Fan with ID " + getId() + " is turned on at speed " + fanSpeed + ".");
    }

    @Override
    public void turnOff() {
        fanSpeed = 0;
        System.out.println("Fan with ID " + getId() + " is turned off (speed set to 0).");
    }

    /**
     * Increases the fan speed by a specified increment value.
     * @param increment The value to increase the fan speed.
     */
    public void increaseFanSpeed(int increment) {
        fanSpeed += increment;
        System.out.println("Fan speed increased to: " + fanSpeed);
    }

    public int getFanSpeed() {
        return fanSpeed;
    }
}
