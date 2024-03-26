package com.strings;

public class ValidAnagaram {
    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "aangarm";
        System.out.println(isAnagramOptimalAg(s1, s2));
    }

    private static boolean isAnagramOptimalAg(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] alpha = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            alpha[s1.charAt(i) - 'a']++;
            alpha[s2.charAt(i) - 'a']--;
        }
        for (int j : alpha) {
            if (j != 0) return false;
        }
        return true;
    }
}
