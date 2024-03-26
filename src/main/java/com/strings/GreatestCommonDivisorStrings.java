package com.strings;

public class GreatestCommonDivisorStrings {
    public static void main(String[] args) {
//        String str1 = "ABC", str2 = "ABCABC";
        String str1 = "ABABAB", str2 = "ABAB";
        System.out.println(gcdOfStringsAg(str1, str2));
    }

    private static String gcdOfStringsAg(String s1, String s2) {
        if (s1.length() < s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        int i = 0;
        int j = i + 1;

        while (s1.charAt(i) != s1.charAt(j)) {
            j++;
        }

        return s1.substring(0, j);
    }

    public static String gcdOfStrings(String w1, String w2) {
        StringBuilder ans = new StringBuilder();

        if (w1.length() > w2.length()) {
            String temp = w1;
            w1 = w2;
            w2 = temp;
        }

        int i = 0;
        int j = 0;

        StringBuilder sb = new StringBuilder();
        while (i < w2.length()) {
            while (i != j && w2.charAt(i) != w2.charAt(j)) {
                char c = w2.charAt(j);
                sb.append(c);
                j++;
            }
            int gap = j - i;
            sb.append(gap);
            i = j;
            i++;
        }

        System.out.println(sb);
//        System.out.println("w1: " + w1);
//        System.out.println("w2: " + w2);

        return ans.toString();
    }
}
