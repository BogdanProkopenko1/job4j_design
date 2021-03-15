package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;

import static java.util.Objects.checkIndex;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] container;
    private int size;
    private int modCounter;

    public int getModCounter() {
        return modCounter;
    }

    public int size() {
        return size;
    }

    public SimpleArray() {
        container = new Object[10];
    }

    private void containerIncrease() {
        container = Arrays.copyOf(container, container.length + 3);
    }

    public Object[] getAll() {
        return container;
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
        return new SimpleArrayIt(this);
    }
}