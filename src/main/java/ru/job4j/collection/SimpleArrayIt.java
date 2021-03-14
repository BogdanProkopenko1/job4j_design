package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayIt<T> implements Iterator<T> {

    private Object[] objects;
    private int counter;
    private final int modCountExpected;
    private SimpleArray<T> simpleArray;

    public SimpleArrayIt(Object[] objects, int modCounter, SimpleArray<T> simpleArray) {
        this.objects = objects;
        modCountExpected = modCounter;
        this.simpleArray = simpleArray;
    }

    @Override
    public boolean hasNext() {
        return counter < objects.length && objects[counter] != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (simpleArray.getModCounter() != modCountExpected) {
            throw new ConcurrentModificationException();
        }
        return (T) objects[counter++];
    }
}