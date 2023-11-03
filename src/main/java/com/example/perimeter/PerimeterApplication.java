package com.example.perimeter;

import com.example.perimeter.algo.PerimeterBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PerimeterApplication {

    public static void main(String[] args) {

        SpringApplication.run(PerimeterApplication.class, args);

//        Parser.parse("2;01.01.2020;31.12.9999;12,3;1");
//        Parser.parse("3;12.11.2021;31.12.9999;25,8;1");
//        Parser.parse("3;14.05.2015;27.03.2023;17,6;2");
//        Parser.parse("3;28.03.2023;31.12.9999;34,3;2");
//        Parser.parse("4;15.02.2022;25.09.2023;5,7;3");
//        Parser.parse("5;11.02.2011;31.12.9999;2,1;1");
//        Parser.parse("6;13.03.2007;31.12.9999;8,4;2");

        List<String> lines = new ArrayList<>();
        lines.add("2;01.01.2020;31.12.9999;12,3;1");
        lines.add("3;12.11.2021;31.12.9999;25,8;1");
        lines.add("3;14.05.2015;27.03.2023;17,6;2");
        lines.add("3;28.03.2023;31.12.9999;34,3;2");
        lines.add("4;15.02.2022;25.09.2023;5,7;3");
        lines.add("5;11.02.2011;31.12.9999;2,1;1");
        lines.add("6;13.03.2007;31.12.9999;8,4;2");

        PerimeterBuilder algo2 = new PerimeterBuilder();
        algo2.buildTree(lines);
    }

}
