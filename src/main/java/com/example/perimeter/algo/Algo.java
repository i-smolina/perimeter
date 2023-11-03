package com.example.perimeter.algo;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Algo {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Map<Integer, Integer> buildTree(List<String> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String line : list) {
            String[] params = line.split(";");
            int id = Integer.parseInt(params[0]);
            LocalDate beginDate = LocalDate.parse(params[1], dateTimeFormatter);
            LocalDate endDate = LocalDate.parse(params[2], dateTimeFormatter);
            int parentId = Integer.parseInt(params[4]);

            if (LocalDate.now().isAfter(endDate) && LocalDate.now().isBefore(beginDate)) continue;

            int level;
            if (map.containsKey(parentId))
                level = map.get(parentId);
            else {
                level = 0;
                map.put(parentId, level);
            }

            level += 1;
            if (map.containsKey(id)) {
                if (level < map.get(id))
                    level = map.get(id);
            }
            map.put(id, level);
        }
        printTree(map);
        return map;
    }

    public void printTree(Map<Integer, Integer> map) {
        map.forEach((key, value) -> System.out.println(key + printT(value)));
    }

    public String printT(int n) {
        return ">".repeat(Math.max(0, n));
    }

}
