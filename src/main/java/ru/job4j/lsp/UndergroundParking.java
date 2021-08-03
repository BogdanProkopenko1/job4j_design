package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class UndergroundParking implements Parking {

    private List<Car> carsParkedLitePlaces = new ArrayList<>();
    private List<Car> carsParkedHeavyPlaces = new ArrayList<>();
    private final int LITE_PARK_PLACES;
    private final int HEAVY_PARK_PLACES;
    private int occupiedLite;
    private int occupiedHeavy;

    public UndergroundParking(int liteParkPlaces, int heavyParkPlaces) {
        this.LITE_PARK_PLACES = liteParkPlaces;
        this.HEAVY_PARK_PLACES = heavyParkPlaces;
    }

    @Override
    public boolean parkCar(Car car) {
        boolean rsl = false;
        double size = car.getSize();
        if (size == 1) {
            rsl = parkLiteCar(car);
        } else if (size > 1) {
            rsl = parkHeavyCar(car);
        }
        return rsl;
    }

    private boolean parkLiteCar(Car car) {
        boolean rsl = false;
        if (occupiedLite < LITE_PARK_PLACES) {
            carsParkedLitePlaces.add(car);
            occupiedLite++;
            rsl = true;
        }
        return rsl;
    }

    private boolean parkHeavyCar(Car car) {
        boolean rsl = false;
        int size = (int) car.getSize();
        if (HEAVY_PARK_PLACES - occupiedHeavy >= size) {
            carsParkedHeavyPlaces.add(car);
            occupiedHeavy += size;
            rsl = true;
        } else if (LITE_PARK_PLACES - occupiedLite >= size) {
            carsParkedLitePlaces.add(car);
            occupiedLite += size;
            rsl = true;
        }
        return rsl;
    }
}
