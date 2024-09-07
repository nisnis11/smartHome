package com.example.smarthome.model;

public class AirConditioner implements Appliance {
    private boolean isOn;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Air Conditioner is turned on.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Air Conditioner is turned off.");
    }

    public boolean isOn() {
        return isOn;
    }
}
