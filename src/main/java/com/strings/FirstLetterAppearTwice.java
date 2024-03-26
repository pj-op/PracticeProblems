package com.strings;

import java.util.HashMap;
import java.util.Map;

public class FirstLetterAppearTwice {
    public static void main(String[] args) {
        String s = "abccbaacz";
        System.out.println(repeatedCharacter(s));
    }

    public static char repeatedCharacter(String s) {
        int n = s.length();
        char j = ' ';
        int ans = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int prevIndex = map.get(c);
                if (i - prevIndex < ans) {
                    ans = i - prevIndex;
                    j = c;
                }
            } else {
                map.put(c, i);
            }
        }
        return j;
    }
}

class IndexStore {
    int element;
    int index;
}