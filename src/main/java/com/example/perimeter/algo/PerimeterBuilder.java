package com.example.perimeter.algo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PerimeterBuilder {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public void buildTree(List<String> list) {
        Tree tree = new Tree();

        for (String line : list) {
            String[] params = line.split(";");
            int id = Integer.parseInt(params[0]);
            LocalDate beginDate = LocalDate.parse(params[1], dateTimeFormatter);
            LocalDate endDate = LocalDate.parse(params[2], dateTimeFormatter);
            float percent = Float.parseFloat(params[3].replace(",","."));
            int parentId = Integer.parseInt(params[4]);

            if (LocalDate.now().isAfter(endDate) && LocalDate.now().isBefore(beginDate)) continue;

           tree.add(id, percent, parentId);

        }
        System.out.println(tree.print());
    }

}
