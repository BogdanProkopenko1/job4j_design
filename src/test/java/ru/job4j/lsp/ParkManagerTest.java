package ru.job4j.lsp;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkManagerTest {

    @Test
    public void park() {
        UndergroundParkManager parkManager = new UndergroundParkManager(
                new UndergroundParking(4, 0)
        );
        Car car0 = new Truck("Scania");
        Car car1 = new PassengerCar("Porsche 911 Carrera");
        Car car2 = new Truck("Man");
        assertTrue(parkManager.park(car0));
        assertTrue(parkManager.park(car1));
        assertFalse(parkManager.park(car2));
    }
}