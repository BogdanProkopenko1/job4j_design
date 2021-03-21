package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.previousIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            T t = i.next();
            if (filter.test(t)) {
                i.remove();
            }
        }
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            T t = i.next();
            if (filter.test(t)) {
                i.set(value);
            }
        }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        Iterator<T> iterator = elements.iterator();
        while (iterator.hasNext()) {
            T t = iterator.next();
            if (list.contains(t)) {
                list.remove(t);
            }
        }
        /*
        ListIterator<T> iterator = list.listIterator();
        Iterator<T> iterator1 = elements.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(iterator1.next())) {
                iterator.remove();
            }
        }

         */
    }
}