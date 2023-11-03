package com.example.perimeter.file;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    public static Map<Integer, Integer> map = new HashMap<>();

//    public static String[] parse(String s, String regex) {
//        return s.split(regex);
//    }

    public static void parse(String s) {
        String[] params = s.split(";");
        System.out.println(List.of(params));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        int id = Integer.parseInt(params[0]);
        LocalDate beginDate = LocalDate.parse(params[1], dateTimeFormatter);
        LocalDate endDate = LocalDate.parse(params[2], dateTimeFormatter);
        int parentId = Integer.parseInt(params[4]);

        if (LocalDate.now().isAfter(endDate) && LocalDate.now().isBefore(beginDate)) return;

//        int level;
//        if (map.containsKey(parentId))
//            level = map.get(parentId);
//        else {
//            level = 0;
//            map.put(parentId, level);
//        }
//
//        level += 1;
//        if (map.containsKey(id)) {
//            if (level < map.get(id))
//                level = map.get(id);
//        }
//        map.put(id, level);
    }
}
