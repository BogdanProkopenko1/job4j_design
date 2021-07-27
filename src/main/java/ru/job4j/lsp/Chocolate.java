package ru.job4j.lsp;

import java.util.Calendar;

public class Chocolate extends Food {
    public Chocolate(String name, Calendar createDate, Calendar expiredDate, double price, double discount) {
        super(name, createDate, expiredDate, price, discount);
    }
}