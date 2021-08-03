package ru.job4j.dip;

import org.slf4j.Marker;

import java.util.ArrayList;

public class DependencyInversion {

    class Food {

        private double weight;
        private double price;

        public Food(double weight, double price) {
            this.weight = weight;
            this.price = price;
        }
    }

    interface Market {
        Food buy(Food food, double money);
    }

    class Five implements Market {

        private ArrayList<Food> foods = new ArrayList<>();

        @Override
        public Food buy(Food food, double money) {
            return null;
        }
    }
}
//аргумент, возвращаемое значение и поля класса зависят от классов(реализаций), а не интерфейсов(абстракций)