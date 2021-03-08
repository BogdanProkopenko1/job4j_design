package ru.job4j.it;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FlatMap<T> implements Iterator<T> {

    private final Iterator<Iterator<T>> data;
    private Iterator<T> iterator;

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return iterator == null || iterator.hasNext() || data.hasNext();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (iterator == null || !iterator.hasNext()) {
            if (data.hasNext()) {
                iterator = data.next();
            }
        }
        /*
        while (iterator == null && data.hasNext()) {
            iterator = data.next();
        }
         */
        return iterator.next();
    }

    public static void main(String[] args) {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator(),
                List.of(4, 5, 6).iterator(),
                List.of(7, 8, 9).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        while (flat.hasNext()) {
            System.out.println(flat.next());
        }
    }
}