package com.dp;

import java.util.Arrays;

public class PerfectSquares {
    public static void main(String[] args) {
        int n = 12;
//        System.out.println(numSquares(n));
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(numSquaresWithBottomUp(n));
    }

    private static int numSquaresWithBottomUp(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int minCount = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int result = 1 + dp[i - (j * j)];
                minCount = Math.min(minCount, result);
            }
            dp[i] = minCount;
        }
        return dp[n];
    }

    private static int numSquares(int n) {
        if (n == 0) return 0;
        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int result = 1 + numSquares(n - (i * i));
            minCount = Math.min(minCount, result);
        }
        return minCount;
    }

    private static int numSquaresWithDp(int n, int[] dp) {
        if (n == 0) return dp[n] = 0;
        if (dp[n] != -1) return dp[n];
        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int result = 1 + numSquaresWithDp(n - (i * i), dp);
            minCount = Math.min(minCount, result);
        }
        return dp[n] = minCount;
    }
}
