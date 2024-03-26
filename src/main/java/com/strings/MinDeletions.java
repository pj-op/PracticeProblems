package com.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinDeletions {
    public static void main(String[] args) {
        String s =
//                "aaabbbcc"
                "abcabc";
        System.out.println(minDeletions(s));
    }

    private static int minDeletions(String s) {
        int deletions = 0;
        int[] alpha = new int[26];

        for (char c : s.toCharArray()) {
            alpha[c - 'a']++;
        }

        Set<Integer> hashSet = new HashSet<>();

        for (int i : alpha) {
            while (i != 0 && hashSet.contains(i)) {
                deletions++;
                i--;
            }
            hashSet.add(i);
        }
        return deletions;
    }
}
