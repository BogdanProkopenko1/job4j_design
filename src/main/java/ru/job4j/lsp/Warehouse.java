package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {

    private ArrayList<Food> storage = new ArrayList<>();

    public ArrayList<Food> getStorage() {
        return storage;
    }

    @Override
    public void add(Food food) {
        storage.add(food);
    }

    @Override
    public List<Food> get() {
        return storage;
    }
}