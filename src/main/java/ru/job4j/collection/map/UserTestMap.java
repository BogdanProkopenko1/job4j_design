package ru.job4j.collection.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class UserTestMap {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 25);
        User userFirst = new User("Alexander", 0, calendar);
        User userSecond = new User("Alexander", 0, calendar);
        Map<User, Object> map = new HashMap<>();
        map.put(userFirst, new Object());
        map.put(userSecond, new Object());
        System.out.println(map);
    }
}