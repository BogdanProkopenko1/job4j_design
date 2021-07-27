package ru.job4j.lsp;

import java.util.*;

public class ControlQuality {

    private Map<String, Storage> storages;

    public ControlQuality(Map<String, Storage> storages) {
        this.storages = storages;
    }

    public Map<String, Storage> getStorages() {
        return storages;
    }

    private Storage check(Food food) {
        double period = food.getExpiredDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        double time = food.getExpiredDate().getTimeInMillis() - new GregorianCalendar().getTimeInMillis();
        double percent = time / period;
        Storage storage;
        if (percent > 1) {
            throw new IllegalArgumentException("Illegal date argument");
        }
        if (percent > 0 && percent < 0.75) {
            storage = getStorages().get("shop");
            if (percent < 0.25) {
                food.setDiscount(food.getDiscount() + 0.3);
            }
        } else if (percent > 0.75) {
            storage = getStorages().get("warehouse");
        } else {
            storage = getStorages().get("trash");
        }
        return storage;
    }

    private void act(Food f) {
        check(f).add(f);
    }

    public static void main(String[] args) {
        Calendar c1 = new GregorianCalendar();
        Calendar e1 = new GregorianCalendar();
        Calendar c2 = new GregorianCalendar();
        Calendar e2 = new GregorianCalendar();
        Calendar c3 = new GregorianCalendar();
        Calendar e3 = new GregorianCalendar();
        Calendar c4 = new GregorianCalendar();
        Calendar e4 = new GregorianCalendar();
        c1.set(2021, Calendar.JULY, 19, 0, 0, 0);
        e1.set(2021, Calendar.JULY, 26, 0, 0, 0);
        c2.set(2021, Calendar.JULY, 1, 0, 0, 0);
        e2.set(2021, Calendar.AUGUST, 1, 0, 0, 0);
        c3.set(2021, Calendar.JULY, 27, 0, 0, 0);
        e3.set(2021, Calendar.SEPTEMBER, 27, 0, 0, 0);
        c4.set(2021, Calendar.JULY, 25, 0, 0, 0);
        e4.set(2021, Calendar.AUGUST, 10, 0, 0, 0);
        Food milk = new Milk("Молоко", c1, e1, 50, 0);
        Food meat = new Meat("Колбаса", c2, e2, 200, 0);
        Food drinks = new Drinks("Pepsi", c3, e3, 150, 0);
        Food chocolate = new Chocolate("Шоколад", c4, e4, 100, 0);
        List<Food> foods = List.of(milk, drinks, chocolate, meat);
        Map<String, Storage> storages = new HashMap<>();
        storages.put("warehouse", new Warehouse());
        storages.put("shop", new Shop());
        storages.put("trash", new Trash());
        ControlQuality controlQuality = new ControlQuality(storages);
        for (Food food : foods) {
            controlQuality.act(food);
        }
        System.out.println("Shop= ");
        storages.get("shop").get().forEach(System.out::println);
        System.out.println("Warehouse= ");
        storages.get("warehouse").get().forEach(System.out::println);
        System.out.println("Trash= ");
        storages.get("trash").get().forEach(System.out::println);
    }
}
