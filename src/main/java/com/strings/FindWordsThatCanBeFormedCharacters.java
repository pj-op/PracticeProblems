package com.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class FindWordsThatCanBeFormedCharacters {
    static int[] charFreq = new int[26];

    public static void main(String[] args) {
        String[] words = {"caaat", "bt", "hat", "tree"};
        String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        int ans = 0;
        for (char ch : chars.toCharArray()) charFreq[ch - 'a']++;
        for (String word : words) if (isGood(word)) ans += word.length();
        return ans;
    }

    private static boolean isGood(String word) {
        int[] localFreq = new int[26];
        for (char ch : word.toCharArray()) localFreq[ch - 'a']++;
        for (int i = 0; i < localFreq.length; i++) {
            if (charFreq[i] < localFreq[i]) return false;
        }
        return true;
    }
}
