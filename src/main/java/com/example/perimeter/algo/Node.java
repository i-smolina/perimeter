package com.example.perimeter.algo;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Node {
    int id;
    float percent;
    Node parent;
    List<Node> children = new ArrayList<>();

    public Node(int id, float percent, Node parent) {
        this(id, percent);
        this.parent = parent;
    }

    public Node(int id, float percent) {
        this.id = id;
        this.percent = percent;
    }

    public void addChild(Node node) {
        node.parent = this;
        children.add(node);
    }

    public void deleteChild(Node node) {
        node.parent = null;
        children.remove(node);
    }
}
