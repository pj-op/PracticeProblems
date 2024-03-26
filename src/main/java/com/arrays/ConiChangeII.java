package com.arrays;

public class ConiChangeII {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change(amount, coins));
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        for (int coin : coins) {
            dp[0] = 1;
            for (int j = coin; j < dp.length; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}
