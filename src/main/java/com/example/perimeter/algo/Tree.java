package com.example.perimeter.algo;

public class Tree {
    Node root = new Node(0, 0);

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
        Node current = search(id);
        if (current != null && percent < current.getPercent()) return;

        Node parent = search(parentId);
        if (parent == null) {
            parent = new Node(parentId, 0, root);
            root.addChild(parent);
        }

        if (current == null) {
            current = new Node(id, percent, parent);
            parent.addChild(current);
        } else {
            current.getParent().deleteChild(current);
            current.setPercent(percent);
            current.setParent(parent);
            parent.addChild(current);
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
        printHierarchy(root, 0);
    }

    private void printHierarchy(Node node, int level) {
        if (node == null) return;
        System.out.println(getBrackets(level) + node.id);
        for (Node child : node.children)
            printHierarchy(child, level + 1);
    }

    private String getBrackets(int n) {
        return ">".repeat(n);
    }

    public void trim(int id) {
        Node node = search(id);
        if (node == null) {
            System.out.println("Not found root id: " + id);
            root = null;
            return;
        }
        node.parent = null;
        root = node;
    }
}
