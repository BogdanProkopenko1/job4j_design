package ru.job4j.lsp;

public class Truck implements HeavyCar {

    private final int SIZE = 3;
    private String model;

    public Truck(String model) {
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