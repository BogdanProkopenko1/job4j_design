package ru.job4j.lsp;

import java.util.Calendar;

public class Drinks extends Food {
    public Drinks(String name, Calendar createDate, Calendar expiredDate, double price, double discount) {
        super(name, createDate, expiredDate, price, discount);
    }
}
