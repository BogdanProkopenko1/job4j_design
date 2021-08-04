package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class UndergroundParking implements Parking {

    private List<Car> carsParkedLitePlaces = new ArrayList<>();
    private List<Car> carsParkedHeavyPlaces = new ArrayList<>();
    private final int liteParkPlaces;
    private final int heavyParkPlaces;
    private int occupiedLite;
    private int occupiedHeavy;

    public UndergroundParking(int liteParkPlaces, int heavyParkPlaces) {
        if (liteParkPlaces < 0 || heavyParkPlaces < 0) {
            throw new IllegalArgumentException("Parking cannot have a negative number of spaces")
;        }
        this.liteParkPlaces = liteParkPlaces;
        this.heavyParkPlaces = heavyParkPlaces;
    }

    @Override
    public boolean parkCar(Car car) {
        boolean rsl = false;
        int size = car.getSize();
        if (size == 1) {
            rsl = parkLiteCar(car);
        } else if (size > 1) {
            rsl = parkHeavyCar(car);
        }
        return rsl;
    }

    private boolean parkLiteCar(Car car) {
        boolean rsl = false;
        if (occupiedLite < liteParkPlaces) {
            carsParkedLitePlaces.add(car);
            occupiedLite++;
            rsl = true;
        }
        return rsl;
    }

    private boolean parkHeavyCar(Car car) {
        boolean rsl = false;
        int size = car.getSize();
        if (heavyParkPlaces > occupiedHeavy) {
            carsParkedHeavyPlaces.add(car);
            occupiedHeavy++;
            rsl = true;
        } else if (liteParkPlaces - occupiedLite >= size) {
            carsParkedLitePlaces.add(car);
            occupiedLite += size;
            rsl = true;
        }
        return rsl;
    }
}
