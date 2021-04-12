package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().filter(a -> a.length() > 0 && !a.contains("#")).forEach(el -> {
                String[] key = el.split("=");
                if (key.length != 2) {
                    throw new IllegalArgumentException();
                }
                values.put(key[0], key[1]);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("C:\\projects\\job4j_design\\app.propeties"));
    }

    /*
    public void loadd() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            List<String> list = new ArrayList<String>();
            read.lines().forEach(list::add);
            for (String el : list) {
                if (el.startsWith("#") || el.length() == 0) {
                    continue;
                }
                String[] arr = el.split("=");
                if (arr.length != 2) {
                    throw new IllegalArgumentException();
                }
                values.put(arr[0], arr[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().filter(a -> a.length() > 0 && !a.contains("#")).forEach(el -> {
                String[] key = el.split("=");
                if (key.length != 2) {
                    throw new IllegalArgumentException();
                }
                values.put(key[0], key[1]);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            Stream<String> rsl = read.lines().filter(a -> a.length() > 0 && !a.contains("#"));
                rsl.forEach({
                        String[] key = el.split("="));
                if (key.length != 2) {
                    throw new IllegalArgumentException();
                }
                values.put(key[0], key[1])
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     */
}