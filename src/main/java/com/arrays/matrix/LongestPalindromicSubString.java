package com.arrays.matrix;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class LongestPalindromicSubString {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindromeWithExpandFromCenter(s));
    }

    private static String longestPalindromeWithExpandFromCenter(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (end - start < len) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandFromCenter(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int left = i, right = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                ans.add(s.substring(left, right + 1));
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                ans.add(s.substring(left, right + 1));
                left--;
                right++;
            }
        }
        return ans.stream().max(Comparator.comparing(String::length)).orElse(null);
    }

    public static String longestPalindromeWithDP(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        Set<String> stringSet = new HashSet<>();

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; j++, i++) {
                if (gap == 0) dp[i][j] = true;
                else {
                    boolean first_and_last_char_equals = s.charAt(i) == s.charAt(j);
                    if (gap == 1) dp[i][j] = first_and_last_char_equals;
                    else dp[i][j] = first_and_last_char_equals && dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    stringSet.add(s.substring(i, j + 1));
                }
            }
        }
        return stringSet.stream().max(Comparator.comparing(String::length)).orElse(null);
    }
}
