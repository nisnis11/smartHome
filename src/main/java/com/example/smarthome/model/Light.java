package com.example.smarthome.model;

public class Light implements Appliance {
    private boolean isOn;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Light is switched on.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Light is switched off.");
    }

    public boolean isOn() {
        return isOn;
    }
}
