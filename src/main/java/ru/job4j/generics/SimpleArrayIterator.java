package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class SimpleArrayIterator<T> implements Iterator<T> {

    private T[] data;
    private int cursor = 0;

    public SimpleArrayIterator(T[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        Optional<T> rsl = Optional.empty();
        if (cursor < data.length) {
            rsl = (Optional<T>) data[cursor];
    }
        return rsl.isPresent();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[cursor++];
    }
}