package ru.job4j.lsp;

import org.junit.Test;
import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void parkLiteCar() {
        assertTrue(
                new UndergroundParking(100, 100)
                .parkCar(new PassengerCar("Aston Martin DB11"))
        );
    }

    @Test
    public void parkHeavyCar() {
        assertTrue(
                new UndergroundParking(100, 100)
                        .parkCar(new Truck("Scania", 2.5D))
        );
    }

    @Test
    public void checkPlaces() {
        Parking parking = new UndergroundParking(0, 0);
        assertFalse(parking.parkCar(new PassengerCar("Porsche 911 Carrera")));
        assertFalse(parking.parkCar(new Truck("Man", 3D)));
    }
}