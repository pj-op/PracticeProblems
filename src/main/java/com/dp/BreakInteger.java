package com.dp;

public class BreakInteger {
    public static void main(String[] args) {
        int n = 50;
        System.out.println(integerBreakOptimal(n));
    }

    private static int integerBreakOptimal(int n) {
        if (n <= 3) return n - 1;
        int ans = 1;
        while (n > 4) {
            ans *= 3;
            n -= 3;
        }
        return ans * n;
    }

    public static int integerBreak(int n) {
        if (n <= 3) return n - 1;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= 3; i++) dp[i] = i;
        for (int num = 4; num <= n; num++) {
            int ans = num;
            for (int i = 2; i < num; i++) {
                ans = Math.max(ans, i * dp[num - i]);
            }
            dp[num] = ans;
        }
        return dp[n];
    }
}
