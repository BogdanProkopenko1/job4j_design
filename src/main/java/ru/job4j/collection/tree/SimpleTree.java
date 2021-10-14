package ru.job4j.collection.tree;

import java.util.function.Predicate;
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
        Predicate<Node<E>> predicate = new Predicate<Node<E>>() {
            @Override
            public boolean test(Node<E> eNode) {
                return eNode.value.equals(value);
            }
        };
        return find(predicate);
    }

    @Override
    public boolean isBinary() {
        Predicate<Node<E>> predicate = new Predicate<Node<E>>() {
            @Override
            public boolean test(Node<E> eNode) {
                return eNode.children.size() <= 2;
            }
        };
        return find(predicate).isEmpty();
    }

    private Optional<Node<E>> find(Predicate<Node<E>> predicate) {
        Optional<Node<E>> optional = Optional.empty();
        Node<E> node;
        List<Node<E>> data = new LinkedList<>();
        data.add(root);
        while (!data.isEmpty()) {
            node = data.remove(0);
            if (predicate.test(node)) {
                optional = Optional.of(node);
                break;
            }
            data.addAll(node.children);
        }
        return optional;
    }
}
