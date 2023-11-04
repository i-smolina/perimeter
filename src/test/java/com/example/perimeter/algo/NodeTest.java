package com.example.perimeter.algo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    Node node1, node2, node3, node4;

    @BeforeEach
    void setUp() {
        node1 = new Node(1, 0);
        node2 = new Node(2, 0);
        node3 = new Node(3,0);
        node4 = new Node(4, 0);
        node1.addChild(node2);
        node1.addChild(node3);
        node2.addChild(node4);
    }

    @Test
    void level_1() {
        assertEquals(0, node1.level());
    }

    @Test
    void level_2() {
        assertEquals(1, node2.level());
    }

    @Test
    void level_3() {
        assertEquals(1, node3.level());
    }

    @Test
    void level_4() {
        assertEquals(2, node4.level());
    }
}