package com.example.perimeter.algo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tree2 {
    public Node root;

    public Node search(Node node, Integer id) {
        if (node == null) return null;
        if (node.id.equals(id)) return node;
        else {
            for (Node child : node.children) {
                Node find = search(child, id);
                if (find != null) return find;
            }
        }
        return null;
    }

    public void add(Integer id, Float percent, Integer parentId) {
        Node parent = search(root, parentId);
        if (parent == null) {
            parent = new Node(parentId, percent,null);
            root = parent;
        }

        Node child = search(root, id);
        if (child == null) {
            child = new Node(id, percent, parent);
            parent.children.add(child);
        }
        else {
            if (percent > child.percent) {
                Node parentPrev = search(root, child.parent.id);
                parentPrev.deleteChild(child);
                child.percent = percent;
                child.parent = parent;
                parent.children.add(child);

            }
        }

    }

    public void print(Node node) {
        System.out.println(node.id + " " + node.level());
        for (Node n : node.children)
            print(n);
    }

    public void print2() {
        print2(root);
    }

    public void print2(Node node) {
        System.out.println(abc(node.level()) + node.id);
        node.children.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.id - o2.id;
            }
        });
        for (Node child : node.children)
            print2(child);
    }

    public String abc(int n) {
        return ">".repeat(n);
    }

    public static class Node {
        private Integer id;
        private Float percent;
        private Node parent;
        private List<Node> children = new ArrayList<>();

        public Node(Integer id, Float percent, Node parent) {
            this.id = id;
            this.percent = percent;
            this.parent = parent;
        }

        public int level() {
            return level(0);
        }

        public int level(int n) {
            if (parent == null) return 0;
            return parent.level(n) + 1;
        }

        public void deleteChild(Node child) {

                    children.remove(child);

        }


    }
}
