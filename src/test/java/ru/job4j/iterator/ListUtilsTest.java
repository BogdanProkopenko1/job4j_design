package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 0, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Predicate<Integer> predicate = e -> e == 2 || e == 4;
        ListUtils.removeIf(input, predicate);
        assertThat(Arrays.asList(1, 3, 5), Is.is(input));
    }

    @Test
    public void whenReplaceIf() {
        List<String> list = Arrays.asList("Petr", "Stas", "Andrey", "Rail");
        Predicate<String> predicate = e -> e.equals("Stas");
        ListUtils.replaceIf(list, predicate, "Bogdan");
        assertThat(Arrays.asList("Petr", "Bogdan", "Andrey", "Rail"), Is.is(list));
    }

    @Test
    public void whenRemoveAll() {
        List<String> list = new ArrayList<>(Arrays.asList("Petr", "Stas", "Dmitry", "Andrey", "Rail", "Bogdan"));
        List<String> list1 = List.of("Petr", "Stas", "Andrey", "Rail");
        ListUtils.removeAll(list, list1);
        assertThat(Arrays.asList("Dmitry", "Bogdan"), Is.is(list));
    }
/*
    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 4));
        ListUtils.addAfter(input, 2, 5);
        assertThat(Arrays.asList(1, 2, 4, 5), Is.is(input));
    }

    @Test
    public void whenAddBeforeFirst() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 4));
        ListUtils.addAfter(input, 0, 0);
        assertThat(Arrays.asList(0, 1, 2, 4), Is.is(input));
    }

 */
}