package ru.job4j.lsp;

import org.junit.Test;
import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void parkLiteCar() {
        assertTrue(
                new UndergroundParking(1, 0)
                .parkCar(new PassengerCar("Aston Martin DB11"))
        );
    }

    @Test
    public void parkHeavyCar() {
        assertTrue(
                new UndergroundParking(0, 1)
                        .parkCar(new Truck("Scania", 3))
        );
    }

    @Test
    public void parkHeavyCarOnLiteCarPlaces() {
        assertTrue(
                new UndergroundParking(3, 0)
                        .parkCar(new Truck("Scania", 3))
        );
    }


    @Test
    public void checkPlaces() {
        Parking parking = new UndergroundParking(0, 0);
        assertFalse(parking.parkCar(new PassengerCar("Porsche 911 Carrera")));
        assertFalse(parking.parkCar(new Truck("Man", 3)));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenIAE() {
        new UndergroundParking(-1, -1);
    }
}