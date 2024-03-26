package com.strings;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "0226";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        int n = s.length();

        if (s.charAt(0) == '0') return 0;
        else if (s.contains("0")) return n - 1;
        else return n;
    }
}
