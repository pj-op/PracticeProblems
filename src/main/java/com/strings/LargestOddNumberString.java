package com.strings;

//https://leetcode.com/problems/largest-odd-number-in-string

public class LargestOddNumberString {
    public static void main(String[] args) {
        String num = "52";
        System.out.println(largestOddNumber(num));
    }

    public static String largestOddNumber(String num) {
        String ans = "";
        int right = num.length() - 1;
        while (right >= 0) {
            int incomingChar = num.charAt(right) - '0';
            if (incomingChar % 2 != 0) return num.substring(0, right + 1);
            right--;
        }
        return ans;
    }
}
