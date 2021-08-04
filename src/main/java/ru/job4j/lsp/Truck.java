package ru.job4j.lsp;

public class Truck implements Car {

    private final int size;
    private String model;

    public Truck(String model, int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Incorrect car size");
        }
        this.model = model;
        this.size = size;
    }

    public String getModel() {
        return model;
    }

    @Override
    public int getSize() {
        return size;
    }
}