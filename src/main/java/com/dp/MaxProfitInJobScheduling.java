package com.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class MaxProfitInJobScheduling {
    static int n = 0;
    static int[] dp = new int[50001];

    public static void main(String[] args) {
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};

        Arrays.fill(dp, -1);

        System.out.println(jobScheduling(startTime, endTime, profit));
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        int[][] jobWithStartEndTime = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobWithStartEndTime[i][0] = startTime[i];
            jobWithStartEndTime[i][1] = endTime[i];
            jobWithStartEndTime[i][2] = profit[i];
        }

        Arrays.sort(jobWithStartEndTime, Comparator.comparingInt(a -> a[0]));
//        System.out.println(Arrays.deepToString(jobWithStartEndTime));

        return solve(jobWithStartEndTime, 0);
    }

    private static int solve(int[][] arr, int i) {
        if (i >= n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int next = getNextIndex(arr, i + 1, arr[i][1]);
        int taken = arr[i][2] + solve(arr, next);
        int notTaken = solve(arr, i + 1);
        return dp[i] = Math.max(taken, notTaken);
    }

    private static int getNextIndex(int[][] arr, int l, int currentJobEnd) {
        int r = n - 1;
        int result = n + 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid][0] >= currentJobEnd) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
}
