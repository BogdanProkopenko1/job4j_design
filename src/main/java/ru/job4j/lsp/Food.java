package ru.job4j.lsp;

import java.util.Calendar;

public class Food {

    private String name;
    private Calendar createDate;
    private Calendar expiredDate;
    private double price;
    private double discount;

    public Food(String name, Calendar createDate, Calendar expiredDate, double price, double discount) {
        this.name = name;
        this.createDate = createDate;
        this.expiredDate = expiredDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public Calendar getExpiredDate() {
        return expiredDate;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", createDate=" + createDate.getTime() +
                ", expiredDate=" + expiredDate.getTime() +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}