package ru.job4j.lsp;

import java.util.GregorianCalendar;

public class QualityChecking {

    public double percentQuality(Food food) {
        double period = food.getExpiredDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        double time = food.getExpiredDate().getTimeInMillis() - new GregorianCalendar().getTimeInMillis();
        return time / period;
    }
}