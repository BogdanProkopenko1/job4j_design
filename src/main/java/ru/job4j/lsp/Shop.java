package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {

    private List<Food> storage = new ArrayList<>();

    public List<Food> getStorage() {
        return storage;
    }

    @Override
    public void add(Food food) {
        storage.add(food);
    }

    @Override
    public List<Food> get() {
        List<Food> list = storage;
        return list;
    }

    @Override
    public boolean accept(Food food) {
        if (food == null) {
            throw new IllegalArgumentException();
        }
        double quality = new QualityCheсking().percentQuality(food);
        if (quality > 1) {
            throw new IllegalArgumentException("Incorrect food expired date");
        }
        boolean rsl = false;
        if (quality > 0 && quality < 0.75) {
            rsl = true;
            if (quality < 0.25) {
                food.setDiscount(food.getDiscount() + 0.3);
            }
        }
        return rsl;
    }
}