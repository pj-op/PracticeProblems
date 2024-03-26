package com.strings;

import java.util.Arrays;

public class DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
        String s1 = "aabbbc";
        String s2 = "abbccc";
        System.out.println(closeStrings(s1, s2));
    }

    public static boolean closeStrings(String w1, String w2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : w1.toCharArray()) {
            freq1[c - 'a']++;
        }
        for (char c : w2.toCharArray()) {
            freq2[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != 0 && freq2[i] != 0) {
                continue;
            }
            if (freq1[i] == 0 && freq2[i] == 0) {
                continue;
            } else {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }
}
