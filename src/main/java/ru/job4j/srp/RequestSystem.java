package ru.job4j.srp;

public interface RequestSystem {

    void add();

    void delete();

    void get();

    void addDB(String request);

    void deleteDB(int id);

    void getDB(int id);
}