package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class LogFilter {

    public static List<String> filter(String file) {
        List<String> rsl = new LinkedList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = in.readLine()) != null) {
                String[] arr = str.split(" ");
                for (String s : arr) {
                    if (s.equals("404")) {
                        rsl.add(" NEW " + str);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}