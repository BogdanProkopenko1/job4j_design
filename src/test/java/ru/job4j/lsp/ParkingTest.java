package ru.job4j.lsp;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void parkLiteCar() {
        Parking parking = new UndergroundParking(100, 100);
        int was = parking.checkLitePlaces();
        LiteCar car = new PassengerCar("Aston Martin DB11");
        parking.parkLiteCar(car);
        assertThat(was - car.getSize(), is(parking.checkLitePlaces()));
    }

    @Test
    public void parkHeavyCar() {
        Parking parking = new UndergroundParking(100, 100);
        int checkHeavyPlaces = parking.checkHeavyPlaces();
        int checkLitePlaces = parking.checkLitePlaces();
        HeavyCar car0 = new Truck("Scania");
        HeavyCar car1 = new Truck("Man");
        parking.parkLiteCar(car1);
        parking.parkHeavyCar(car0);
        assertThat(checkHeavyPlaces - car0.getSize(), is(parking.checkHeavyPlaces()));
        assertThat(checkLitePlaces - car1.getSize(), is(parking.checkLitePlaces()));
    }

    @Test
    public void checkPlaces() {
        Parking parking = new UndergroundParking(100, 50);
        assertThat(parking.checkHeavyPlaces(), is(50));
        assertThat(parking.checkLitePlaces(), is(100));
    }
}