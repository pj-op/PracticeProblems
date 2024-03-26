package com.dp;

import java.util.*;
import java.util.stream.Collectors;

public class MaximumValueOfKCoinsFromPiles {
    public static void main(String[] args) {
        int[][] piles = {{1, 100, 3}, {7, 8, 9}};
        int k = 2;
        List<List<Integer>> pilesList = new ArrayList<>();
        Arrays.stream(piles).forEach(x -> pilesList.add(Arrays.stream(x).boxed().collect(Collectors.toList())));
        System.out.println(maxValueOfCoins(pilesList, k));
    }

    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int coins = 0; coins <= k; coins++) {
                int currentSum = 0;
                for (int currentCoins = 0; currentCoins <= Math.min(piles.get(i - 1).size(), coins); currentCoins++) {
                    if (currentCoins > 0) {
                        currentSum += piles.get(i - 1).get(currentCoins - 1);
                    }
                    dp[i][coins] = Math.max(dp[i][coins], dp[i - 1][coins - currentCoins] + currentSum);
                }
            }
        }
        return dp[n][k];
    }
}
