package ru.job4j.kiss;

import com.sun.jdi.event.StepEvent;

import java.sql.PreparedStatement;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MaxMin {

    private <T> T sort(List<T> list, Comparator<T> comparator, Predicate<Integer> predicate) {
        T rsl = list.get(0);
        for (T el : list) {
            if (predicate.test(comparator.compare(el, rsl))) {
                rsl = el;
            }
        }
        return rsl;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return new MaxMin().sort(value, comparator, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        });
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return new MaxMin().sort(value, comparator, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer < 0;
            }
        });
    }
}