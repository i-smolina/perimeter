package com.example.perimeter.algo;

public class Tree {
    Node root;

    public Node search(int id) {
        return search(root, id);
    }

    private Node search(Node node, int id) {
        if (node == null) return null;
        if (node.getId() == id) return node;
        for (Node child : node.getChildren()) {
            Node found = search(child, id);
            if (found != null)
                return found;
        }
        return null;
    }

    public void add(int id, float percent, int parentId) {
        Node parent = search(parentId);
        if (parent == null) {
            parent = new Node(parentId, percent, null);
            root = parent;
        }
        Node current = search(id);
        if (current == null) {
            current = new Node(id, percent, parent);
            parent.addChild(current);
        } else {
            if (percent > current.getPercent()) {
                current.getParent().deleteChild(current);
                current.setPercent(percent);
                current.setParent(parent);
                parent.addChild(current);
            }
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        print(root, sb);
        return sb.toString();
    }

    private void print(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.id);
        for (Node child : node.children)
            print(child, sb);
    }

    public void printHierarchy() {
        printHierarchy(root);
    }

    private void printHierarchy(Node node) {
        if (node == null) return;
        System.out.println(getBrackets(node.level()) + node.id);
        for (Node child : node.children)
            printHierarchy(child);
    }

    private String getBrackets(int n) {
        return ">".repeat(n);
    }
}
