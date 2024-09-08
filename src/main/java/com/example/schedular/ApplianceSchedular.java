package com.example.schedular;
import com.example.service.ApplianceService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component public class ApplianceSchedular {
    private final ApplianceService applianceService;
    public ApplianceSchedular(ApplianceService applianceService) {
        this.applianceService = applianceService;
    }
    @Scheduled(cron = "${turnoff.appliance:0 0 1 1 1 *}") 
   // @Scheduled(cron = "${turnoff.appliance:0 0/1 * * * *}") 
    public void turnOffAppliances() {
        System.out.print("Running scheduler to turn off the appliances");
        applianceService.turnOffAppliance("fan1");
        applianceService.turnOffAppliance("fan2");
        applianceService.turnOffAppliance("ac1");
        applianceService.turnOffAppliance("light1");
    }
}