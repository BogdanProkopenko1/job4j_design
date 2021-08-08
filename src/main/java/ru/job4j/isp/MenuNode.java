package ru.job4j.isp;

public interface MenuNode<T> {

    T action(T param);
}