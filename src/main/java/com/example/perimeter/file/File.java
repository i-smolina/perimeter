package com.example.perimeter.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class File {
    public static List<String> read(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            List<String> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null)
                lines.add(line);
            return lines;
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            return new ArrayList<>();
        }
    }
}
