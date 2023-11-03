package com.example.perimeter.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void testEquals() {
        Node rootActual = new Node(1, 0, null);
        Node actual = new Node(2, 0, rootActual);
        rootActual.children.add(actual);

        Node rootExpected = new Node(5, 0, null);
        rootExpected.children.add(new Node(2, 0, rootExpected));
        assertEquals(rootActual, rootExpected);
    }
}