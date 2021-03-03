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
        if (count >= nums.length) return false;
        if (check()) {
            return true;
        } else {
            count++;
            return hasNext();
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return nums[count++];
    }
}