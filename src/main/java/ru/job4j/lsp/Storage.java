package ru.job4j.lsp;

import java.util.List;

public interface Storage {

    public void add(Food food);

    public List<Food> get();
}
