package com.strings;

import java.util.List;
import java.util.Set;

public class MaxVowelsInSubString {
    public static void main(String[] args) {
        String s =
//                "abciiidef"
//                "aeiou"
//                "zzxxxao"
//                "leetcode"
                "rhythms";
        int k = 4;
        /*System.out.println(maxVowels(s, k));*/
        System.out.println(vowels(s, k));
    }

    private static int vowels(String s, int k) {
        int[] vowels = {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        int max_vow = 0;
        for (int i = 0, cur_vow = 0; i < s.length(); ++i) {
            cur_vow += vowels[s.charAt(i) - 'a'];
            if (i >= k) {
                cur_vow -= vowels[s.charAt(i - k) - 'a'];
                System.out.println("Inside if: " + cur_vow);
            }
            max_vow = Math.max(cur_vow, max_vow);
        }
        return max_vow;
    }

    public static int maxVowels(String s, int k) {
        int maxVowelCount = Integer.MIN_VALUE;
        for (int j = 0; j < s.length() - (k - 1); j++) {
            maxVowelCount = Math.max(maxVowelCount, countVowels(s.substring(j, j + k)));
        }
        return maxVowelCount;
    }

    private static int countVowels(String substring) {
        List<Character> vowelsList = List.of('a', 'e', 'i', 'o', 'u');
        int count = 0;
        for (char c : substring.toCharArray()) {
            if (vowelsList.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
