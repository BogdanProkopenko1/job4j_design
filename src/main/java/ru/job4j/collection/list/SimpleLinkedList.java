package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
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
        checkIndex(index, size);
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> node = first;
            private int count;
            private int modExpected = modCount;

            @Override
            public boolean hasNext() {
                if (modExpected != modCount) {
                    throw new ConcurrentModificationException();
                }
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