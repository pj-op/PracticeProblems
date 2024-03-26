package com.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeConcatenatingTwoLetterWords {
    public static void main(String[] args) {
        String[] words =
//                {"lc", "cl", "gg"};
                {"ab", "ty", "yt", "lc", "cl", "ab"};
        System.out.println(longestPalindrome(words));
    }

    public static int longestPalindrome(String[] words) {
        int res = 0;
        boolean centerUsed = false;
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);

        System.out.println(freqMap);

        for (String word : words) {
            String reverse = revString(word);
            if (!word.equals(reverse)) {
                if (freqMap.containsKey(word) && freqMap.containsKey(reverse) && freqMap.get(word) >= 1 && freqMap.get(reverse) >= 1) {
                    res += 4;
                    freqMap.put(word, freqMap.get(word) - 1);
                    freqMap.put(reverse, freqMap.get(reverse) - 1);
                }
            } else {
                if (freqMap.containsKey(word) && freqMap.get(word) >= 2) {
                    res += 4;
                    freqMap.put(word, freqMap.get(word) - 2);
                } else if (freqMap.containsKey(word) && freqMap.get(word) == 1 && !centerUsed) {
                    res += 2;
                    freqMap.put(word, freqMap.get(word) - 1);
                    centerUsed = true;
                }
            }
        }

        return res;
    }

    public static String revString(String str) {
        char[] charStr = str.toCharArray();
        char temp = charStr[0];
        charStr[0] = charStr[1];
        charStr[1] = temp;

        return String.valueOf(charStr);
    }

}
