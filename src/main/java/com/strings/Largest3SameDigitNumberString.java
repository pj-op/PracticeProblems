package com.strings;

public class Largest3SameDigitNumberString {
    public static void main(String[] args) {
        String num = "2300019";
        System.out.println(largestGoodInteger(num));
    }

    public static String largestGoodInteger(String num) {
        int iStart = 1;
        int maxNum = Integer.MIN_VALUE;
        while (iStart < num.length()) {
            if (iStart + 1 < num.length() && num.charAt(iStart - 1) == num.charAt(iStart) && num.charAt(iStart) == num.charAt(iStart + 1)) {
                int currNum = Integer.parseInt(num.substring(iStart - 1, iStart + 2));
                maxNum = Math.max(maxNum, currNum);
            }
            iStart++;
        }
        if (maxNum == 0) return "000";
        return maxNum == Integer.MIN_VALUE ? "" : String.valueOf(maxNum);
    }
}
