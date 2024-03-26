package com.dp;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinCostToCutStick {
    public static void main(String[] args) {
        int n = 9;
        int[] cuts = {5, 6, 1, 4, 2};
        System.out.println(minCost(n, cuts));
    }

    public static int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] newCuts = new int[cuts.length + 2];
        IntStream.range(1, newCuts.length - 1).forEach(i -> newCuts[i] = cuts[i - 1]);
        newCuts[newCuts.length - 1] = n;
        int[][] dp = new int[cuts.length + 1][cuts.length + 1];

        IntStream.range(0, dp.length).forEach(i -> Arrays.fill(dp[i], -1));
        System.out.println(Arrays.deepToString(dp));

        return function(1, cuts.length, newCuts, dp);
    }

    private static int function(int i, int j, int[] cuts, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int min_cost = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = cuts[j + 1] - cuts[i - 1] + function(i, k - 1, cuts, dp) + function(k + 1, j, cuts, dp);
            min_cost = Math.min(min_cost, cost);
        }
        return dp[i][j] = min_cost;
    }
}

