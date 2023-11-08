package com.example.perimeter.algo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PerimeterBuilderTest {
    PerimeterBuilder perimeterBuilder;

    @BeforeEach
    void setUp() {
        perimeterBuilder = new PerimeterBuilder();
    }

    @Test
    void build() {
        List<String> lines = List.of(
                "ID;BEGDA;ENDDA;PERCENT;PARENT_ID",
                "2;01.01.2020;31.12.9999;12,3;1",
                "3;12.11.2021;31.12.9999;25,8;1",
                "3;14.05.2015;27.03.2023;17,6;2",
                "3;28.03.2023;31.12.9999;34,3;2",
                "4;15.02.2022;25.09.2023;5,7;3",
                "5;11.02.2011;31.12.9999;2,1;1",
                "6;13.03.2007;31.12.9999;8,4;2"
        );
        Tree actual = perimeterBuilder.buildTree(lines, LocalDate.of(2023, Month.SEPTEMBER, 22));
        assertEquals("0123465", actual.print());
    }

    @Test
    void build_2() {
        List<String> lines = List.of(
                "ID;BEGDA;ENDDA;PERCENT;PARENT_ID",
                "4;15.02.2022;25.09.2023;5,7;3",
                "5;11.02.2011;31.12.9999;2,1;1",
                "6;13.03.2007;31.12.9999;8,4;2",
                "2;01.01.2020;31.12.9999;12,3;1",
                "3;12.11.2021;31.12.9999;25,8;1",
                "3;14.05.2015;27.03.2023;17,6;2",
                "3;28.03.2023;31.12.9999;34,3;2"
        );
        Tree actual = perimeterBuilder.buildTree(lines, LocalDate.of(2023, Month.SEPTEMBER, 22));
        assertEquals("0152634", actual.print());
    }

    @Test
    void build_3() {
        List<String> lines = List.of(
                "ID;BEGDA;ENDDA;PERCENT;PARENT_ID",
                "3;28.03.2023;31.12.9999;34,3;2",
                "4;15.02.2022;25.09.2023;5,7;3",
                "5;11.02.2011;31.12.9999;2,1;1",
                "6;13.03.2007;31.12.9999;8,4;2",
                "2;01.01.2020;31.12.9999;12,3;1",
                "3;12.11.2021;31.12.9999;25,8;1",
                "3;14.05.2015;27.03.2023;17,6;2"
        );
        Tree actual = perimeterBuilder.buildTree(lines, LocalDate.of(2023, Month.SEPTEMBER, 22));
        assertEquals("0152346", actual.print());
    }

    @Test
    void build_4() {
        List<String> lines = List.of(
                "ID;BEGDA;ENDDA;PERCENT;PARENT_ID",
                "6;13.03.2007;31.12.9999;8,4;2",
                "5;11.02.2011;31.12.9999;2,1;1",
                "4;15.02.2022;25.09.2023;5,7;3",
                "3;28.03.2023;31.12.9999;34,3;2",
                "3;14.05.2015;27.03.2023;17,6;2",
                "3;12.11.2021;31.12.9999;25,8;1",
                "2;01.01.2020;31.12.9999;12,3;1"
        );
        Tree actual = perimeterBuilder.buildTree(lines, LocalDate.of(2023, Month.SEPTEMBER, 22));
        assertEquals("0152634", actual.print());
    }

    @Test
    void build_on_date_2022_09_22() {
        List<String> lines = List.of(
                "ID;BEGDA;ENDDA;PERCENT;PARENT_ID",
                "2;01.01.2020;31.12.9999;12,3;1",
                "3;12.11.2021;31.12.9999;25,8;1",
                "3;14.05.2015;27.03.2023;17,6;2",
                "3;28.03.2023;31.12.9999;34,3;2",
                "4;15.02.2022;25.09.2023;5,7;3",
                "5;11.02.2011;31.12.9999;2,1;1",
                "6;13.03.2007;31.12.9999;8,4;2"
        );
        Tree actual = perimeterBuilder.buildTree(lines, LocalDate.of(2022, Month.SEPTEMBER, 22));
        assertEquals("0126345", actual.print());
    }
}