package com.example.service;

public class AirConditioner extends Appliance {

    public AirConditioner(String id) {
        super(id);
    }

    @Override
    public void turnOn() {
        System.out.println("Air Conditioner is now ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Air Conditioner is now OFF");
    }
}
