package com.strings;

import java.util.Arrays;

public class StringMultiplication {
    public static void main(String[] args) {
        String s1 = "630";
        String s2 = "40";
        System.out.println(stringMultiplication(s1, s2));
    }

    private static String stringMultiplication(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[] result = new int[l1 + l2];

        int pf = 0;
        int i = l1 - 1;
        while (i >= 0) {
            int iVal = s1.charAt(i) - '0';
            i--;
            int k = result.length - 1 - pf;
            int carry = 0;
            int j = l2 - 1;
            while (j >= 0 || carry != 0) {
                int jVal = j >= 0 ? s2.charAt(j) - '0' : 0;
                j--;
                int prod = iVal * jVal + carry + result[k];
                carry = prod / 10;
                result[k] = prod % 10;
                k--;
            }
            pf++;
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int a : result) {
            if (a == 0 && !flag) continue;
            else {
                flag = true;
                sb.append(a);
            }
        }
        return sb.toString();
    }
}
