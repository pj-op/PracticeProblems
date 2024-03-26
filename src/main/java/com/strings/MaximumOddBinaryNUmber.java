package com.strings;

public class MaximumOddBinaryNUmber {
    public static void main(String[] args) {
        String str = "0101";
        System.out.println(maximumOddBinaryNumber(str));
    }

    private static String maximumOddBinaryNumber(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        int countOf1 = 0;
        int i = 0;
        while (i != n) {
            sb.append("0");
            if (s.charAt(i) == '1') countOf1++;
            i++;
        }

        int l = 0;
        while (countOf1 - 1 > 0) {
            sb.setCharAt(l++, '1');
            countOf1--;
        }

        sb.setCharAt(n - 1, '1');
        return sb.toString();

    }
}
