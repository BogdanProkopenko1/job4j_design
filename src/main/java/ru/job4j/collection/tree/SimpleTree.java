package ru.job4j.collection.tree;

import java.util.*;

class SimpleTree<E> implements Tree<E> {

    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> el = findBy(parent);
        Optional<Node<E>> children = findBy(child);
        if (el.isPresent() && children.isEmpty()) {
            Optional<E> val = el.get().children.stream().map(eNode -> eNode.value).filter(e -> e.equals(child)).findFirst();
            if (!val.isPresent()) {
                el.get().children.add(new Node<>(child));
                rsl = true;
            }
        }
        return rsl;
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
}
