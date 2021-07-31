package ru.job4j.lsp;

public class PassengerCar implements LiteCar {

    private final int SIZE = 1;
    private String model;

    public PassengerCar(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public int getSize() {
        return SIZE;
    }
}