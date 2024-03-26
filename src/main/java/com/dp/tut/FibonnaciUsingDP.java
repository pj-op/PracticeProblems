package com.dp.tut;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class FibonnaciUsingDP {
    public static void main(String[] args) {
        int num = 10;
        int[] dp = new int[num + 1];
        Arrays.fill(dp, -1);

        Instant startTime = Instant.now();
        System.out.println(
//                fibOfNumUsingTabulation(num)
                fibOfNumUsingRecursion(num, dp)
//                fibonnaciUsingConstantTime(num)
        );
        Instant endTIme = Instant.now();
        System.out.println(Duration.between(startTime, endTIme).toNanos());
    }

    private static int fibonnaciUsingConstantTime(int num) {
        int first = 0;
        int second = 1;
        int ans = 0;

        for (int i = 2; i <= num; i++) {
            ans = first + second;
            first = second;
            second = ans;
        }

        return ans;
    }

    private static int fibOfNumUsingRecursion(int num, int[] dp) {
        if (num <= 1) return num;
        else if (dp[num] != -1) return dp[num];
        return fibOfNumUsingRecursion(num - 1, dp) + fibOfNumUsingRecursion(num - 2, dp);
    }

    private static int fibOfNumUsingTabulation(int num) {
        int[] dp = new int[num + 1];
        for (int i = 0; i < dp.length; i++) {
            if (i == 0) dp[i] = 0;
            else if (i == 1) dp[i] = 1;
            else dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[num];
    }
}
