package com.example.smarthome.model;

public class Fan implements Appliance {
    private int speed;

    @Override
    public void turnOn() {
        speed = 1; // Default speed when turning on
        System.out.println("Fan is switched on at speed " + speed);
    }

    @Override
    public void turnOff() {
        speed = 0;
        System.out.println("Fan is switched off.");
    }

    public int getSpeed() {
        return speed;
    }

    public void increaseSpeed() {
        if (speed < 2) {
            speed++;
            System.out.println("Fan speed increased to " + speed);
        } else {
            System.out.println("Fan is already at maximum speed.");
        }
    }

    public void decreaseSpeed() {
        if (speed > 0) {
            speed--;
            System.out.println("Fan speed decreased to " + speed);
        } else {
            System.out.println("Fan is already off.");
        }
    }
}
