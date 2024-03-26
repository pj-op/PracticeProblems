package com.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ZigZagConversion {
    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(zigzag(str, numRows));
    }

    private static String zigzag(String str, int numRows) {
        int count = 0;
        StringBuilder strAns = new StringBuilder();
        boolean flag = false;
        List<StringBuilder> ans = new ArrayList<>();
        IntStream.range(0, numRows).forEach(i -> ans.add(new StringBuilder()));
        for (int i = 0; i < str.length(); i++) {
            if (!flag) {
                if (count < numRows) count++;
                else if (count == numRows) flag = true;
            }
            if (flag) {
                count--;
                if (count == 1) flag = false;
            }
            ans.get(count - 1).append(str.charAt(i));
        }
        ans.forEach(strAns::append);
        return strAns.toString();
    }
}
