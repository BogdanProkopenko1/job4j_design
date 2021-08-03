package ru.job4j.lsp;

public class Truck implements Car {

    private final double SIZE;
    private String model;

    public Truck(String model, double size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Incorrect car size");
        }
        this.model = model;
        this.SIZE = size;
    }

    public String getModel() {
        return model;
    }

    @Override
    public double getSize() {
        return SIZE;
    }
}