package ru.job4j.collection.tree;

import java.util.*;

class SimpleTree<E> implements Tree<E> {

    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> el = findBy(parent);
        if (el.isPresent() && findBy(child).isEmpty()) {
            el.get().children.add(new Node<>(child));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    @Override
    public boolean isBinary() {
        return queue().stream()
                .filter(e -> e.children.size() > 2)
                .findFirst()
                .isEmpty();
    }

    private Queue<Node<E>> queue() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        return data;
    }
}
