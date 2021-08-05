package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {

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
    public void clear() {
        storage.clear();
    }

    @Override
    public boolean accept(Food food) {
        if (food == null) {
            throw new IllegalArgumentException();
        }
        double quality = new QualityChecking().percentQuality(food);
        if (quality > 1) {
            throw new IllegalArgumentException("Incorrect food expired date");
        }
        boolean rsl = false;
        if (quality < 0) {
            rsl = true;
        }
        return rsl;
    }
}