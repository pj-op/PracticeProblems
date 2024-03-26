package com.strings;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ExcelSheetToTitle {

    public static void main(String[] args) {
        int columnNumber = 701;
//        System.out.println(Integer.valueOf('A'));
        System.out.println(convertToTitle(columnNumber));
    }

    public static String convertToTitle(int columnNumber) {
        char[] alpha = new char[26];
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, alpha.length).forEach(i -> alpha[i] = (char) (65 + i));
        while (columnNumber != 0) {
            columnNumber = columnNumber - 1;
            sb.append(alpha[columnNumber % 26]);
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }
}
