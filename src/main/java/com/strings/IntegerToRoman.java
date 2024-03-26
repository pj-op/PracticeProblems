package com.strings;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntegerToRoman {
    public static void main(String[] args) {
        int num = 1995;
//        System.out.println(intToRoman(num));
        generateNumSeries();
    }

    public static String intToRoman(int num) {
        /*
        M - 1000
        D - 500
        C - 100
        L - 50
        X - 10
        V - 5
        I - 1
         */


        StringBuilder ans = new StringBuilder();

        process(ans, ' ', 'M', ' ', num / 1000);
        num %= 1000;
        process(ans, 'M', 'C', 'D', num / 100);
        num %= 100;
        process(ans, 'C', 'X', 'L', num / 10);
        num %= 10;
        process(ans, 'X', 'I', 'V', num);


        return ans.toString();
    }

    private static void generateNumSeries() {
        AtomicInteger ts = new AtomicInteger(1);
        AtomicInteger fs = new AtomicInteger(5);

//        System.out.println(ts.get());
//        System.out.println(fs.get());
//        IntStream.rangeClosed(2, 6).forEach(i -> System.out.println(i % 2 == 0 ? (ts.updateAndGet(k -> k * 10)) : (fs.updateAndGet(k -> k * 10))));

        Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
                .map(x -> x[0])
                .limit(10)
                .forEach(System.out::println);

    }

    private static void process(StringBuilder sb, char major, char minor, char middle, int val) {
        if (val <= 3) {
            sb.append("I".repeat(Math.max(0, val)));
        } else if (val == 4) {
            sb.append(minor);
            sb.append(middle);
        } else if (val == 5) {
            sb.append(middle);
        } else if (val <= 8) {
            sb.append(middle);
            sb.append(String.valueOf(minor).repeat(val));
        } else if (val == 9) {
            sb.append(minor);
            sb.append(major);
        }
    }
}
