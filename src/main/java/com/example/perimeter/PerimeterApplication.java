package com.example.perimeter;

import com.example.perimeter.algo.PerimeterBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PerimeterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerimeterApplication.class, args);

        if (args.length < 3) {
            System.out.println("Error: enter filename, date, id!");
            return;
        }
        String filename = args[0];
        String date = args[1];
        String id = args[2];

        PerimeterBuilder perimeterBuilder = new PerimeterBuilder();
        perimeterBuilder.buildFromFile(filename, date, id);
    }
}
