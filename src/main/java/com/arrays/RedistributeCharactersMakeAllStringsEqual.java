package com.arrays;

public class RedistributeCharactersMakeAllStringsEqual {
    public static void main(String[] args) {
        String[] words = {"ab", "a"};
//                {"aaa","a"};
//                {"abc", "aabc", "bc"};
        System.out.println(makeEqual(words));
    }

    public static boolean makeEqual(String[] words) {
        int n = words.length;
        int[] freq = new int[26];

        for (String word : words) {
            int i = 0;
            while (i < word.length()) {
                freq[word.charAt(i++) - 'a']++;
            }
        }

        for (int fr : freq) {
            if (fr % n == 0) return false;
        }

        return true;
    }
}
