package com.example.perimeter.algo;

import com.example.perimeter.file.File;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PerimeterBuilder {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public void buildFromFile(String filename, String onDate) {
        List<String> lines = File.read(filename);
        build(lines, onDate);
    }

    public void build(List<String> lines, String onDate) {
        Tree tree = buildTree(lines, onDate);
        printTree(tree);
    }

    private Tree buildTree(List<String> lines, String dateFromStr) {
        LocalDate date = parseDateOrNow(dateFromStr);
        Tree tree = new Tree();
        for (String line : lines) {
            String[] params = line.split(";");

            int id, parentId;
            LocalDate beginDate, endDate;
            float percent;
            try {
                id = Integer.parseInt(params[0]);
                beginDate = LocalDate.parse(params[1], dateTimeFormatter);
                endDate = LocalDate.parse(params[2], dateTimeFormatter);
                percent = Float.parseFloat(params[3].replace(",", "."));
                parentId = Integer.parseInt(params[4]);
            }
            catch (NumberFormatException | DateTimeException e) {
                System.out.println("Couldn't parse line : " + line);
                continue;
            }

            if (date.isAfter(endDate) || date.isBefore(beginDate)) continue;
            tree.add(id, percent, parentId);
        }
        return tree;
    }

    private void printTree(Tree tree) {
        tree.printHierarchy();
    }

    private LocalDate parseDateOrNow(String dateFromStr) {
        LocalDate date;
        try {
            date = LocalDate.parse(dateFromStr, dateTimeFormatter);
        }
        catch (DateTimeException e) {
            date = LocalDate.now();
        }
        return date;
    }
}
