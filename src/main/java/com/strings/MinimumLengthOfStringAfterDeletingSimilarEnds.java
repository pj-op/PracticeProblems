package com.strings;

public class MinimumLengthOfStringAfterDeletingSimilarEnds {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(minimumLength(s));
    }

    private static int minimumLength(String s) {
        int i = 0;
        int j = s.length() - 1;

        char ithChar = s.charAt(i);
        char jthChar = s.charAt(j);

        while (i < j && ithChar == jthChar) {
            char ch = s.charAt(i);
            while (i < j && s.charAt(i) == ch) {
                i++;
            }
            while (j >= i && s.charAt(j) == ch) {
                j--;
            }
        }
        return j - i + 1;
    }
}
