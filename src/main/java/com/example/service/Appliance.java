package com.example.service;

/**
 * Abstract class representing a generic appliance.
 */
public abstract class Appliance {
    private String id;

    public Appliance(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract void turnOn();
    public abstract void turnOff();
}
