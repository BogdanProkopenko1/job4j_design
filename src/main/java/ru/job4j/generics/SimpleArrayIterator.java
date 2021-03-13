package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayIterator<T> implements Iterator<T> {

    private T[] data;
    private int cursor = 0;

    public SimpleArrayIterator(T[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return cursor < data.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[cursor++];
    }
}