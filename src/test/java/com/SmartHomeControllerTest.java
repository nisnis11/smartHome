package com;

import com.example.smarthome.model.Appliance;
import com.example.smarthome.service.SmartHomeController;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.mockito.Mockito.*;

public class SmartHomeControllerTest {

    @Test
    public void testTurnAllOn() {
        Appliance mockLight = mock(Appliance.class);
        Appliance mockFan = mock(Appliance.class);

        SmartHomeController controller = new SmartHomeController(Arrays.asList(mockLight, mockFan));
        controller.turnAllOn();

        verify(mockLight, times(1)).turnOn();
        verify(mockFan, times(1)).turnOn();
    }

    @Test
    public void testTurnAllOff() {
        Appliance mockLight = mock(Appliance.class);
        Appliance mockFan = mock(Appliance.class);

        SmartHomeController controller = new SmartHomeController(Arrays.asList(mockLight, mockFan));
        controller.turnAllOff();

        verify(mockLight, times(1)).turnOff();
        verify(mockFan, times(1)).turnOff();
    }
}
