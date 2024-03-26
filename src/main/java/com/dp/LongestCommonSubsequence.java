package com.dp;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "xayzce", text2 = "ace";
//        System.out.println(longestCommonSubsequenceUsingRecursionAndMemo(text1, text2));
        System.out.println(longestCommonSubsequenceUsingBottomUp(text1, text2));
    }

    private static int longestCommonSubsequenceUsingBottomUp(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    //Using Recursion and memoization
    public static int longestCommonSubsequenceUsingRecursionAndMemo(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        IntStream.range(0, dp.length).forEach(i -> Arrays.fill(dp[i], -1));
        return solveUsingRecursionAndMemo(s1, s2, 0, 0, dp);
    }

    private static int solveUsingRecursionAndMemo(String s1, String s2, int i, int j, int[][] dp) {
        if (i >= s1.length() || j >= s2.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + solveUsingRecursionAndMemo(s1, s2, i + 1, j + 1, dp);
        }
        return dp[i][j] = Math.max(solveUsingRecursionAndMemo(s1, s2, i, j + 1, dp), solveUsingRecursionAndMemo(s1, s2, i + 1, j, dp));
    }
}

