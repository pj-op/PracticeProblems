package com.strings;

import java.util.Arrays;

public class FindTheDiff {
    public static void main(String[] args) {
        String
//                s = "a", t = "aa"
//                s = "", t = "y"
                s = "abcd", t = "abcde"
                ;
        System.out.println(findTheDifference(s, t));
    }

    private static char findTheDifference(String s, String t) {

        int[] alphabets = new int[26];

        for (char c : t.toCharArray()) {
            alphabets[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            alphabets[c - 'a']--;
        }

        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] == 1) {
                return (char) (i + 'a');
            }
        }
        return 0;
    }

    public static char findTheDifference1(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            if (!s.contains(String.valueOf(t.charAt(i)))) {
                return t.charAt(i);
            }
        }
        return ' ';
    }

}
