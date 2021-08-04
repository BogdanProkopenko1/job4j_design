package ru.job4j.lsp;

public class PassengerCar implements Car {

    private final int size = 1;
    private String model;

    public PassengerCar(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public int getSize() {
        return size;
    }
}