package com.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MaximumPalindromesAfterOperations {
    public static void main(String[] args) {
        String[] words =
                {"cd", "ef", "a"};
//                {"abbb", "ba", "aa"};
        System.out.println(maxPalindromesAfterOperations(words));
    }

    private static int maxPalindromesAfterOperations(String[] words) {
        int totalPalindrome = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
        }
        //Calculate the pair count
        int pairCount = 0;
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() >= 2) {
                pairCount += entry.getValue() / 2;
            }
        }
        Arrays.sort(words, Comparator.comparing(String::length));

        for (String word : words) {
            if (pairCount >= (word.length() / 2)) {
                pairCount -= (word.length() / 2);
                totalPalindrome++;
            }
//            else return totalPalindrome;
        }
        return totalPalindrome;
    }
}
