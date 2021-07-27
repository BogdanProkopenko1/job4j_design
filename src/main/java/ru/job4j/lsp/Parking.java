package ru.job4j.lsp;

public interface Parking {

    public void parkLiteCar(Car car);

    public void parkHeavyCar(HeavyCar car);

    public int checkLitePlaces();

    public int checkHeavyPlaces();
}