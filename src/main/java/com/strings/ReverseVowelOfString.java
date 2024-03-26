package com.strings;

import java.util.Arrays;
import java.util.List;

public class ReverseVowelOfString {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        int r = -1;
        int l = -1;
        int left = 0;
        boolean lf = false;
        boolean rf = false;
        int right = s.length() - 1;
        char leftChar, rightChar;
        char[] ans = s.toCharArray();
        List<Character> vowelList = Arrays.asList('a', 'e', 'i', 'o', 'u');

        while (left < right) {
            leftChar = s.charAt(left);
            rightChar = s.charAt(right);

            if (vowelList.contains(leftChar) && !lf) {
                l = left;
                lf = true;
            }

            if (vowelList.contains(rightChar) && !rf) {
                r = right;
                rf = true;
            }

            if (l != -1 && r != -1) {
                char temp = ans[l];
                ans[l] = ans[r];
                ans[r] = temp;
                l = -1;
                r = -1;
                lf = false;
                rf = false;
            }

            if (!lf) left++;
            if (!rf) right--;
        }

        return String.valueOf(ans);
    }
}
