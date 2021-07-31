package ru.job4j.lsp;

public class UndergroundParkManager implements ParkManager {

    private final Parking PARKING;

    public UndergroundParkManager(Parking parking) {
        this.PARKING = parking;
    }

    @Override
    public boolean park(Car car) {
        return true;
    }
}
