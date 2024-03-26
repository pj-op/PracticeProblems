package com.maths;

import java.util.Arrays;

public class Tribonnaci {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(tribonnaci(n));
    }

    private static int tribonnaci(int n) {
        if (n == 0) return 0;
        if (n > 0 && n <= 2) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
