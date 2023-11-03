package com.example.perimeter.algo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {
    Tree tree;

    @BeforeEach
    void setUp() {
        tree = new Tree();
        Node node1 = new Node(1, 0);
        Node node2 = new Node(2, 0);
        Node node3 = new Node(3,0);
        Node node4 = new Node(4, 0);
        node1.addChild(node2);
        node1.addChild(node3);
        node2.addChild(node4);
        tree.root = node1;
    }

    @Test
    void search_emptyTree() {
        tree = new Tree();
        assertNull(tree.search(1));
    }

    @Test
    void search_1() {
        assertEquals(1, tree.search(1).id);
    }

    @Test
    void search_2() {
        assertEquals(2, tree.search(2).id);
    }

    @Test
    void search_3() {
        assertEquals(3, tree.search(3).id);
    }

    @Test
    void search_4() {
        assertEquals(4, tree.search(4).id);
    }

    @Test
    void search_5() {
        assertNull(tree.search(5));
    }

    @Test
    void add_12() {
        Tree tree = new Tree();
        tree.add(2, 0, 1);
        assertEquals("12", tree.print());
    }

    @Test
    void add_1243() {
        tree.add(5, 0, 3);
        assertEquals("12435", tree.print());
    }

    @Test
    void print_empty() {
        Tree tree = new Tree();
        assertEquals("", tree.print());
    }

    @Test
    void print_1243() {
        assertEquals("1243", tree.print());
    }

    @Test
    void print_12() {
        Tree tree = new Tree();
        tree.root = new Node(1, 0, null);
        tree.root.children.add(new Node(2, 0, tree.root));
        assertEquals("12", tree.print());
    }

    @Test
    void print_123() {
        Tree tree = new Tree();
        tree.root = new Node(1, 0, null);
        tree.root.children.add(new Node(2, 0, tree.root));
        tree.root.children.add(new Node(3,0,tree.root));
        assertEquals("123", tree.print());
    }
}