package ru.job4j.gc;

public class User {

    private String login;
    private String password;
    private int id;

    public User(String login, String password, int id) {
        this.login = login;
        this.password = password;
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d%n", id);
    }

    public static void main(String[] args) {
        new User("login №1", "password №1", 1);
        new User("login №2", "password №2", 2);
        new User("login №3", "password №3", 3);
        new User("login №4", "password №4", 4);
        new User("login №5", "password №5", 5);
    }
}
