package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> last;
    int size;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            if (last == null) {
                last = node;
            }
            return;

        }
        last.next = node;
        last = node;
        size++;
    }

    public boolean revert() {
        if (size < 2) {
            return false;
        }
        Node<T> curr = head;
        Node<T> pre = null;
        Node<T> incoming = null;
        while (curr != null) {
            incoming = curr.next;   // store incoming item
            curr.next = pre;        // swap nodes
            pre = curr;             // increment also pre
            curr = incoming;        // increment current
        }
        head = pre;
        return true;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> rsl = head;
        head = rsl.next;
        size--;
        return rsl.value;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> rsl = head;
        T rtn = last.value;
        while (rsl.next != null) {
            if (rsl.next.next == null) {
                last = rsl.next.next;
                last.next = null;
            }
            rsl = rsl.next;
        }
        size--;
        return rtn;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}