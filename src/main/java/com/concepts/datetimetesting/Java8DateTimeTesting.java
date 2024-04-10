package com.concepts.datetimetesting;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Java8DateTimeTesting {

    public static void main(String[] args) {
//        testLocalDateTime();
//        testZoneDateTime();
//        testClock();
//        testDateTimeFormatter();
//        testPeriod();
        convertingDateAndCalendarToLocalDateTime();
    }

    private static void convertingDateAndCalendarToLocalDateTime() {
        Date date = new Date();
        LocalDateTime localDateTime1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        Calendar calendar = Calendar.getInstance();
        LocalDateTime localDateTime2 = calendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("localDateTime1: " + localDateTime1 + ", localDateTime2: " + localDateTime2);
    }

    private static void testPeriod() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(1996, Month.MAY, 10);
        System.out.println(Period.between(localDate1, localDate));
        System.out.println(ChronoUnit.DAYS.between(localDate1, localDate));
    }

    private static void testDateTimeFormatter() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

    private static void testClock() {
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.instant());

        Clock clock1 = Clock.offset(clock, Duration.ofHours(10));
        System.out.println(clock1.instant());
    }

    private static void testZoneDateTime() {
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId.getDisplayName(TextStyle.FULL, Locale.US));

        for (String zone : ZoneId.getAvailableZoneIds()) {
            System.out.println(zone + ": " + ZonedDateTime.now(ZoneId.of(zone)));
        }

    }

    private static void testLocalDateTime() {
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2022, 9, 20);
        LocalDate localDate3 = LocalDate.of(1996, Month.MAY, 10);

        System.out.println(localDate3.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US));

        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = LocalTime.of(10, 20, 20);

        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(2022, 10, 1, 20, 20, 2);

        System.out.println("localDate1: " + localDate1 + " localDate2: " + localDate2 + " localDate3: " + localDate3);
        System.out.println("localTime1: " + localTime1 + " localTime2: " + localTime2);
        System.out.println("localDateTime1: " + localDateTime1 + " localDateTime2: " + localDateTime2);

    }


}
