package ru.job4j.collection.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.util.Objects.checkIndex;

public class SimpleLinkedList<E> implements List<E>, Iterable<E>{

    private int size;
    private Node<E> first;
    private Node<E> last;
    private int modCount;

    private static class Node<E> {

        E element;
        Node<E> previous;
        Node<E> next;

        Node(E element, Node<E> previous, Node<E> next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }
    }

    @Override
    public void add(E value) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(value, l, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> rsl = first;
        for (int count = 0; count < size; count++) {
            if (index == 0) {
                return rsl.element;
            }
            rsl = rsl.next;
            count++;
            if (count == index) {
                return rsl.element;
            }
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> node = first;
            private int count;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E rtn = node.element;
                node = node.next;
                count++;
                return rtn;
            }
        };
    }
}