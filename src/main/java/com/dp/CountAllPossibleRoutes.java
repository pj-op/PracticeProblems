package com.dp;

import java.util.Arrays;

public class CountAllPossibleRoutes {
    public static void main(String[] args) {
        int[] locations = {2, 3, 6, 8, 4};
        int start = 1, finish = 3, fuel = 5;
        System.out.println(countRoutes(locations, start, finish, fuel));
    }

    public static int countRoutes(int[] locations, int start, int finish, int fuel) {
        long[][] dp = new long[locations.length][fuel + 1];
        long MOD = (long) (1e9 + 7);
        Arrays.fill(dp[finish], 1);
        long ans = 0;
        for (int i = 0; i <= fuel; i++) {
            for (int j = 0; j < locations.length; j++) {
                for (int k = 0; k < locations.length; k++) {
                    if (k == j) continue;
                    if (Math.abs(locations[j] - locations[k]) <= i) {
                        dp[j][i] = (dp[j][i] + dp[k][i - Math.abs(locations[j] - locations[k])]) % MOD;
                    }
                }
            }
        }
        return (int) dp[start][fuel];
    }
}
