package ru.job4j.collection.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class UserTestMap {

    public static void main(String[] args) {
        User user = new User("Alexander", 0, Calendar.getInstance());
        Map<User, Object> map = new HashMap<>();
        map.put(user, "First");
        map.put(user, "Second");
        System.out.println(map);
    }
}