package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class SimpleArrayIterator<T> implements Iterator<T> {

    private T[] data;
    private int cursor = 0;
    private int size;

    public SimpleArrayIterator(T[] data, int size) {
        this.data = data;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return cursor < size;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[cursor++];
    }
}