package com.dp;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost =
                {10, 15, 20};
//                {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 1; i < cost.length; i++) {
            if (i > 1) {
                dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            }
        }
        dp[dp.length - 1] = Math.min(dp[dp.length - 2], dp[dp.length - 3]);
//        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }
}
