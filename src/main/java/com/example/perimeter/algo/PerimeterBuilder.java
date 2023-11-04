package com.example.perimeter.algo;

import com.example.perimeter.file.File;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PerimeterBuilder {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public void buildFromFile(String filename, String onDate, String id) {
        List<String> lines = File.read(filename);
        build(lines, onDate, id);
    }

    public void build(List<String> lines, String onDate, String id) {
        int rootId;
        LocalDate date;
        try {
            rootId = Integer.parseInt(id);
            date = LocalDate.parse(onDate, dateTimeFormatter);
        }
        catch (NumberFormatException | DateTimeException e) {
            System.out.println("Error: " + e);
            return;
        }
        Tree tree = buildTree(lines, date);
        tree.trim(rootId);
        printTree(tree);
    }

    private Tree buildTree(List<String> lines, LocalDate date) {

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
}
