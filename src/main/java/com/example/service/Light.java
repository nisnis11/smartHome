package com.example.service;

public class Light extends Appliance {

    public Light(String id) {
        super(id);
    }

    @Override
    public void turnOn() {
        System.out.println("Light is now ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Light is now OFF");
    }
}
