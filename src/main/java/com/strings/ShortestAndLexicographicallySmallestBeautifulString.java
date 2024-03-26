package com.strings;

public class ShortestAndLexicographicallySmallestBeautifulString {
    public static void main(String[] args) {
//        String s = "100011001"; int k = 3;
        String s = "1011";
        int k = 2;
//        String s = "001110101101101111"; int k = 10;
        System.out.println(shortestBeautifulSubstring(s, k));
    }

    public static String shortestBeautifulSubstring(String s, int k) {
        String res = "";
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            int len = 0;
            for (int j = i; j < s.length(); j++) {
                len++;
                if (s.charAt(j) == '1') count++;
                if (count == k) {
                    var substring = s.substring(i, j + 1);
                    if (len < minLen) {
                        minLen = len;
                        res = substring;
                    }
                    if (len == minLen && substring.compareTo(res) < 0) {
                        res = substring;
                    }
                }
            }
        }
        return res;
    }
}