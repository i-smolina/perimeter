package com.example.perimeter.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeAddTest {
    @Test
    void add_1_2_toEmptyTree() {
        Tree tree = new Tree();
        tree.add(2, 0, 1);
        assertEquals("012", tree.print());
    }

    @Test
    void add_1243() {
        Tree tree = new Tree();
        tree.add(2, 0, 1);
        tree.add(4, 0, 3);
        tree.add(3, 0, 1);
        assertEquals("01234", tree.print());
    }

    @Test
    void add_1243_with_percent() {
        Tree tree = new Tree();
        tree.add(2, 5, 1);
        tree.add(4, 6, 3);
        tree.add(3, 7, 1);
        assertEquals("01234", tree.print());
    }

    @Test
    void add_1243_with_percent_next_less() {
        Tree tree = new Tree();
        tree.add(2, 5, 1);
        tree.add(4, 8, 3);
        tree.add(4, 6, 2);
        tree.add(3, 7, 1);
        assertEquals("01234", tree.print());
    }

    @Test
    void add_1243_with_percent_next_greater() {
        Tree tree = new Tree();
        tree.add(2, 5, 1);
        tree.add(4, 6, 3);
        tree.add(4, 8, 2);
        tree.add(3, 7, 1);
        assertEquals("01243", tree.print());
    }
}
