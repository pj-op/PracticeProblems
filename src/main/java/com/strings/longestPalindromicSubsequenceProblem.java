package com.strings;

import java.util.Arrays;

public class longestPalindromicSubsequenceProblem {
    public static void main(String[] args) {
        String text1 = "zzazz";
        System.out.println(longestPalindromicSubsequence(text1));
    }

    public static int longestPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][n - 1];
    }
}
