package com.strings;

import java.util.Set;

public class DetermineifStringHalvesAreAlike {
    public static void main(String[] args) {
        String s = "textbook";
        System.out.println(halvesAreAlike(s));
    }

    public static boolean halvesAreAlike(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int n = s.length();
        int vowelCount = 0;
        int i = 0;
        while (i < n / 2) {
            char c = s.charAt(i);
            if (vowels.contains(c)) {
                vowelCount++;
            }
            i++;
        }

        int j = n / 2;
        while (j < n) {
            char c = s.charAt(j);
            if (vowels.contains(c)) {
                vowelCount--;
            }
            j++;
        }

        return vowelCount == 0;
    }
}
