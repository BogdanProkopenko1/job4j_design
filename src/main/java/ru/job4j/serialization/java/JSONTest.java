package ru.job4j.serialization.java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class JSONTest {

    private boolean resolution;
    private int balance;
    private String login;
    private String[] requisites;
    private User user;

    public boolean isResolution() {
        return resolution;
    }

    public void setResolution(boolean resolution) {
        this.resolution = resolution;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String[] getRequisites() {
        return requisites;
    }

    public void setRequisites(String[] requisites) {
        this.requisites = requisites;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JSONTest(boolean resolution, int balance, String login, String[] requisites, User user) {
        this.resolution = resolution;
        this.balance = balance;
        this.requisites = requisites;
        this.login = login;
        this.user = user;
    }

    @Override
    public String toString() {
        return "JSONTest{" +
                "resolution=" + resolution +
                ", balance=" + balance +
                ", login='" + login + '\'' +
                ", requisites=" + Arrays.toString(requisites) +
                ", user=" + user +
                '}';
    }

    public static void main(String[] args) {
        JSONTest pre = new JSONTest(
                true, 0, "log", new String[]{"hr", "pm"},
                new User("Name", "password")
        );
        final Gson gson = new GsonBuilder().create();
        String el = gson.toJson(pre);
        System.out.println(el);
        final JSONTest post = gson.fromJson(el, JSONTest.class);
        System.out.println(post);
    }
}
