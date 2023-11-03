package com.example.perimeter;

import com.example.perimeter.exception.IllegalLine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Getter
@Setter
@AllArgsConstructor
public class Company {
    private int id;
    private LocalDate beginDate;
    private LocalDate endDate;
    private float percent;
    private int parentId;

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Company(String[] params) throws IllegalLine {
        try {
            int id = Integer.parseInt(params[0]);
            LocalDate beginDate = LocalDate.parse(params[1], dateTimeFormatter);
            LocalDate endDate = LocalDate.parse(params[2], dateTimeFormatter);
            int parentId = Integer.parseInt(params[4]);
        }
        catch (NumberFormatException| DateTimeException e) {
            throw new IllegalLine();
        }

    }

}
