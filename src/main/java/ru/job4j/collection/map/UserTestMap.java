package ru.job4j.collection.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class UserTestMap {

    public static void main(String[] args) {
        User userFirst = new User("Alexander", 0, Calendar.getInstance());
        User userSecond = new User("Alexander", 0, Calendar.getInstance());
        Map<User, Object> map = new HashMap<>();
        map.put(userFirst, "First");
        map.put(userSecond, "Second");
        System.out.println(map);
    }
}