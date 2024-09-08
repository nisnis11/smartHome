package com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.service.Appliance;
import com.example.service.ApplianceService;
import com.example.service.Fan;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SmartHomeControllerTest {

    @InjectMocks
    private ApplianceService smartHomeController;

    @Mock
    private List<Appliance> appliances;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testTurnOnAppliance() {
        // Arrange
        Fan fan = new Fan("fan1");
        when(appliances.stream().filter(a -> a.getId().equals("fan1")).findFirst()).thenReturn(java.util.Optional.of(fan));

        // Act
        String result = smartHomeController.turnOnAppliance("fan1");

        // Assert
        assertEquals("Appliance with ID fan1 turned on.", result);
        verify(appliances).stream();
        verifyNoMoreInteractions(appliances);
    }

    @Test
    public void testTurnOffAppliance() {
        // Arrange
        Fan fan = new Fan("fan1");
        when(appliances.stream().filter(a -> a.getId().equals("fan1")).findFirst()).thenReturn(java.util.Optional.of(fan));

        // Act
        String result = smartHomeController.turnOffAppliance("fan1");

        // Assert
        assertEquals("Appliance with ID fan1 turned off.", result);
        verify(appliances).stream();
        verifyNoMoreInteractions(appliances);
    }

    @Test
    public void testIncreaseFanSpeed() {
        // Arrange
        Fan fan = new Fan("fan1");
        when(appliances.stream().filter(a -> a.getId().equals("fan1")).findFirst()).thenReturn(java.util.Optional.of(fan));

        // Act
        String result = smartHomeController.increaseFanSpeed("fan1", 3);

        // Assert
        assertEquals("Increased fan speed of appliance with ID fan1 by 3.", result);
        assertEquals(3, fan.getFanSpeed()); // Check fan speed increment
        verify(appliances).stream();
        verifyNoMoreInteractions(appliances);
    }

    @Test
    public void testTurnOnApplianceNotFound() {
        // Arrange
        when(appliances.stream().filter(a -> a.getId().equals("fan1")).findFirst()).thenReturn(java.util.Optional.empty());

        // Act
        String result = smartHomeController.turnOnAppliance("fan1");

        // Assert
        assertEquals("Appliance not found.", result);
        verify(appliances).stream();
        verifyNoMoreInteractions(appliances);
    }

    @Test
    public void testIncreaseFanSpeedNotFound() {
        // Arrange
        when(appliances.stream().filter(a -> a.getId().equals("fan1")).findFirst()).thenReturn(java.util.Optional.empty());

        // Act
        String result = smartHomeController.increaseFanSpeed("fan1", 3);

        // Assert
        assertEquals("Appliance not found.", result);
        verify(appliances).stream();
        verifyNoMoreInteractions(appliances);
    }

    @Test
    public void testIncreaseFanSpeedNotFan() {
        // Arrange
        Appliance light = new Fan("light1") {
            @Override
            public void turnOn() { }
            @Override
            public void turnOff() { }
        };
        when(appliances.stream().filter(a -> a.getId().equals("light1")).findFirst()).thenReturn(java.util.Optional.of(light));

        // Act
        String result = smartHomeController.increaseFanSpeed("light1", 3);

        // Assert
        assertEquals("Appliance with ID light1 does not support fan speed adjustments.", result);
        verify(appliances).stream();
        verifyNoMoreInteractions(appliances);
    }
}
