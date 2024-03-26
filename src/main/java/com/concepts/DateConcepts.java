package com.concepts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateConcepts {
    public static void main(String[] args) {
        String inputDate = "2023-06-08 23:12:10.0";
//        System.out.println(LocalDateTime.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        LocalDate endDate = LocalDate.now();
        LocalDate startDate = LocalDate.now().minusMonths(1);
        System.out.println(startDate + " --- " + endDate);

        int count = 5;
        while (count > 0) {
            endDate = startDate;
            startDate = startDate.minusMonths(1);
            System.out.println(startDate + " --- " + endDate);
            count--;
        }


    }
}
