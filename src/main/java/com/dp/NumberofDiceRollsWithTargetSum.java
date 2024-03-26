package com.dp;

public class NumberofDiceRollsWithTargetSum {
    static int[][] dp;

    public static void main(String[] args) {
        int n = 1, k = 6, target = 3;
        System.out.println(numRollsToTarget(n, k, target, dp));
    }

    public static int numRollsToTarget(int n, int k, int target, int[][] dp) {
        dp = new int[31][1001];
        return solveUsingRec(n, k, target, dp);
    }

    private static int solveUsingRec(int n, int k, int target, int[][] dp) {
        int m = 1_00_000_007;
        if (target < 0) return 0;
        if (dp[n][target] != -1) return dp[n][target];
        if (n == 0) return dp[n][target] = 0;

        int ways = 0;
        for (int i = 1; i <= k; i++) {
            ways += solveUsingRec(n - 1, k, target - 1, dp);
        }
        return dp[n][target] = ways;
    }
}
