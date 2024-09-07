package com.example.smarthome.controller;

import com.example.smarthome.service.SmartHomeController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplianceController {

    private final SmartHomeController smartHomeController;

    public ApplianceController(SmartHomeController smartHomeController) {
        this.smartHomeController = smartHomeController;
    }

    @GetMapping("/turnOnAll")
    public void turnOnAllAppliances() {
        smartHomeController.turnAllOn();
    }

    @GetMapping("/turnOffAll")
    public void turnOffAllAppliances() {
        smartHomeController.turnAllOff();
    }
}
