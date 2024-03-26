package com.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    private final int MOD = 1000000007;
    private int[][][] dp = new int[101][101][101];

    public int countProfitableSchemes(int idx, int currProfit, int currSize, int totalSize, int minProfit, List<Integer> groupSizes, List<Integer> profits) {
        // Base case: reached end of group sizes list
        if (idx == groupSizes.size()) {
            return currProfit >= minProfit ? 1 : 0;
        }

        // Check if already computed and return the stored result
        if (dp[idx][currProfit][currSize] != -1) {
            return dp[idx][currProfit][currSize];
        }

        // Compute the result by either skipping or taking the current group size
        int skip = countProfitableSchemes(idx + 1, currProfit, currSize, totalSize, minProfit, groupSizes, profits);
        int take = 0;
        if (currSize + groupSizes.get(idx) <= totalSize) {
            take = countProfitableSchemes(idx + 1, Math.min(currProfit + profits.get(idx), minProfit), currSize + groupSizes.get(idx), totalSize, minProfit, groupSizes, profits);
        }

        // Store and return the computed result
        dp[idx][currProfit][currSize] = (skip + take) % MOD;
        return dp[idx][currProfit][currSize];
    }

    public int profitableSchemes(int n, int minProfit, int[] groupSizes, int[] profits) {
        // Initialize the dp array with -1
        for (int[][] arr2D : dp) {
            for (int[] arr : arr2D) {
                Arrays.fill(arr, -1);
            }
        }
        List<Integer> groups = new ArrayList<>();
        List<Integer> profitList = new ArrayList<>();
        Arrays.stream(groupSizes).forEach(groups::add);
        Arrays.stream(groupSizes).forEach(profitList::add);

        // Call the recursive function with initial parameters
        return countProfitableSchemes(0, 0, 0, n, minProfit, groups, profitList);
    }
}
