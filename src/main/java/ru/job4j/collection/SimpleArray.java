package ru.job4j.collection;

import java.util.Iterator;

import static java.util.Objects.checkIndex;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] container;
    public int size;
    private int modCounter;

    public int getModCounter() {
        return modCounter;
    }

    public SimpleArray() {
        container = new Object[10];
    }

    private void containerIncrease() {
        Object[] rsl = new Object[container.length + 1];
        for (int i = 0; i < container.length; i++) {
            rsl[i] = container[i];
        }
        container = rsl;
    }

    public T get(int index) {
        checkIndex(index, size);
        return (T) container[index];
    }

    public void add(T model) {
        if (size >= container.length) {
            containerIncrease();
        }
        container[size++] = model;
        modCounter++;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIt(container, modCounter, this);
    }
}