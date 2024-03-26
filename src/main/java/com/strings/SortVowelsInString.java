package com.strings;

import java.util.Arrays;

public class SortVowelsInString {
    public static void main(String[] args) {
        String s = "lEetcOde";
        System.out.println(sortVowels(s));
    }

    public static String sortVowels(String s) {
        StringBuilder ans = new StringBuilder();
        int countVowel = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) countVowel++;
        }
        char[] vowelArr = new char[countVowel];
        int i = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) vowelArr[i++] = c;
        }
        Arrays.sort(vowelArr);
        i=0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                ans.append(vowelArr[i++]);
            } else ans.append(c);
        }
        return ans.toString();
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
