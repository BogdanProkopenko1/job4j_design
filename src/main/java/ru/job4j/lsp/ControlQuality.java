package ru.job4j.lsp;

import java.util.*;

public class ControlQuality {

    private List<Storage> storages;

    public ControlQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public List<Storage> getStorages() {
        List<Storage> storages = this.storages;
        return storages;
    }

    public void act(Food food) {
        for (Storage storage : getStorages()) {
            if (storage.accept(food)) {
                storage.add(food);
            }
        }
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
        ControlQuality controlQuality =
                new ControlQuality(List.of(new Warehouse(), new Shop(), new Trash()));
        for (Food food : foods) {
            controlQuality.act(food);
        }
        System.out.println("Warehouse= ");
        controlQuality.getStorages().get(0).get().forEach(System.out::println);
        System.out.println("Shop= ");
        controlQuality.getStorages().get(1).get().forEach(System.out::println);
        System.out.println("Trash= ");
        controlQuality.getStorages().get(2).get().forEach(System.out::println);
    }
}
