package com.dp;

//https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/?envType=daily-question&envId=2023-10-15

import java.util.Arrays;

public class NumOfWaysToStayInTheSamePlaceAfterSomeSteps {
    public static void main(String[] args) {
        int steps = 4, arrLen = 2;
        System.out.println(numWays(steps, arrLen));
    }

    public static int numWays(int steps, int arrLen) {
        int mod = 1000000007;
        int maxPosition = Math.min(steps, arrLen);
        long[][] dp = new long[steps + 1][maxPosition + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j < maxPosition; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j + 1] + (j > 0 ? dp[i - 1][j - 1] : 0)) % mod;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return (int) dp[steps][0];
    }
}
