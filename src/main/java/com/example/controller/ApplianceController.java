package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.service.ApplianceService;

@RestController
@RequestMapping("/appliances")
public class ApplianceController {

    @Autowired
    private ApplianceService applianceService;

    @GetMapping("/turnOn")
    public String turnOnAppliance(@RequestParam("id") String id) {
        return applianceService.turnOnAppliance(id);
    }

    @GetMapping("/test")
    public String getTetst() {
        return "hello";
    }

    @GetMapping("/turnOff")
    public String turnOffAppliance(@RequestParam("id") String id) {
        return applianceService.turnOffAppliance(id);
    }

    @PostMapping("/increaseFanSpeed")
    public String increaseFanSpeed(@RequestParam("id") String id, @RequestParam("increment") String increment) {
        int incrementValue = Integer.parseInt(increment);
        return applianceService.increaseFanSpeed(id, incrementValue);
    }
}
