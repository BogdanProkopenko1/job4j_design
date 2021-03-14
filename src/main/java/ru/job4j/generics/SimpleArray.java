package ru.job4j.generics;

import java.util.Iterator;
import java.util.Objects;

import static java.util.Objects.checkIndex;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] models;
    private int count = 0;

    public SimpleArray(int size) {
        if (size > 0) {
            models = new Object[size];
        }
    }

    public void add(T model) {
        checkIndex(count, models.length);
        models[count++] = model;
    }

    public void set(int index, T model) {
        checkIndex(index, count);
        models[index] = model;
    }

    public void remove(int index) {
        checkIndex(index, count);
        System.arraycopy(models, index + 1, models, index, models.length - 1);
        count--;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator(this.models, this.count);
    }
}