package ru.job4j.isp;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<Node> nodes = new ArrayList<>();

    public boolean addParagraph(String context, Node node) {
        if (node == null) {
            throw new NullPointerException();
        }
        if (context == null) {
            return nodes.add(node);
        }
        Node node1 = search(context);
        if (node1.isEmpty()) {
            throw new NullPointerException();
        }
        return node1.addParagraph(node);
    }

    public boolean deleteParagraph(String context) {
     //   return search(context).map(node -> getMenu().remove(node)).orElse(false);
        return search(context).delete();
    }

    public Node search(String context) {
        Node node = new Node();
        if (nodes.size() != 0) {
            for (Node e : nodes) {
                if (e.getText().equals(context)) {
                    return e;
                }
                if (e.nodes.size() != 0) {
                    node = iterate(e, context, new Node());
                    if (node.isEmpty()) {
                        continue;
                    }
                    return node;
                }
            }
        }
        return node;
       // Tree<Node> s = new Tree
        //return getMenu().stream().filter(e -> e.getText().equals(context)).findFirst().get();

    }

    public Node iterate(Node n, String s, Node rsl) {
        for (Node node1 : n.nodes) {
            if (node1.text.equals(s)) {
                rsl = node1;
            } else if (node1.nodes.size() != 0) {
                rsl = iterate(node1, s, rsl);
            }
        }
        return rsl;
        // n.nodes.stream().filter(e -> e.getText().equals(s)).findFirst().orElse(e -> iterate(e, s));
      //  if (n.nodes.size() != 0) {
         /*   Node noda = new Node();
            for (Node node : n.nodes) {
                if (node.getText().equals(s)) {
                    return node;
                }
            }
            for (Node node : n.nodes) {
                if (node.nodes.size() == 0) {
                    continue;
                }
                iterate(node, s);
            }
       // }
        return noda;

          */
    }

    static class Node implements MenuNode {

        private List<Node> nodes = new ArrayList<>();
        private String text;
        private Object object;
        private Node parent;

        public Node(Object o, String text, Node parent) {
            this.object = o;
            this.text = text;
            this.parent = parent;
        }

        public Node() {}

        private String getText() {
            return text;
        }

        private boolean addParagraph(Node node) {
            return nodes.add(node);
        }

        private boolean delete() {
            return parent.nodes.remove(this);
        }

        private boolean isEmpty() {
            return nodes.size() == 0 && text == null && object == null;
        }

        @Override
        public String toString() {
            return text;
        }

        @Override
        public Object action(Object param) {
            return null;
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addParagraph(null, new Node(1, "First 1", null));
        menu.addParagraph("First 1", new Node(1, "---Second 1", menu.search("First 1")));
        menu.addParagraph(null, new Node(1, "First 2", null));
        menu.addParagraph("---Second 1", new Node(1, "------Third 1", menu.search("---Second 1")));
        menu.addParagraph(null, new Node(1, "First 3", null));
        menu.addParagraph(null, new Node(1, "First 4", null));
        menu.addParagraph("First 2", new Node(1, "---Second 1.1", menu.search("First 2")));
        menu.addParagraph("---Second 1.1", new Node(1, "------Third 1.1", menu.search("---Second 1.1")));
        menu.addParagraph("First 2", new Node(1, "---Second 2.1", menu.search("First 2")));
        menu.addParagraph("First 1", new Node(1, "---Second 2", menu.search("First 1")));
        menu.addParagraph("---Second 2", new Node(1, "------Third 2", menu.search("---Second 2")));
        menu.addParagraph("------Third 2", new Node(1, "---------Fourth 1", menu.search("------Third 2")));
        menu.addParagraph("---------Fourth 1", new Node(1, "------------Fiver 1", menu.search("---------Fourth 1")));
        menu.addParagraph("------Third 1.1", new Node(1, "---------Fourth 1.1", menu.search("------Third 1.1")));
        menu.addParagraph("------Third 1.1", new Node(1, "---------Fourth 1.2", menu.search("------Third 1.1")));
        menu.addParagraph("---Second 2.1", new Node(1, "---------Fourth 2.1", menu.search("---Second 2.1")));
        menu.addParagraph("------Third 1", new Node(1, "---------Fourth 1", menu.search("------Third 1")));
        menu.addParagraph("------------Fiver 1", new Node(1, "---------------Six 1", menu.search("------------Fiver 1")));
        menu.nodes.forEach(q -> {
            System.out.println(q.toString());
            q.nodes.forEach(n -> {
                System.out.println(n.toString());
                n.nodes.forEach(a -> {
                    System.out.println(a.toString());
                    a.nodes.forEach(l -> {
                        System.out.println(l.toString());
                        l.nodes.forEach(e -> {
                            System.out.println(e.toString());
                            e.nodes.forEach(o -> {
                                System.out.println(o.toString());
                                o.nodes.forEach(s -> {
                                    System.out.println(s.toString());
                                    s.nodes.forEach(p -> {
                                        System.out.println(p.toString());
                                        p.nodes.forEach(System.out::println);
                                    });
                                });
                            });
                        });
                    });
                });
            });
        });
    }
}