package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {

    private final int[] nums;
    private int count;

    public EvenIt(int[] nums) {
        this.nums = nums;
    }

    public boolean check() {
        return nums[count] % 2 == 0;
    }

    @Override
    public boolean hasNext() {
        boolean rsl = false;
        if (count < nums.length) {
            while (count + 1 < nums.length && !check()) {
                count++;
            }
            rsl = check();
        }
        return rsl;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return nums[count++];
    }
}