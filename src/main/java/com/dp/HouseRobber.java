package com.dp;

import org.hibernate.event.spi.SaveOrUpdateEvent;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HouseRobber {

    static int[] dp;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(robIterativeUsingVariables(arr));
    }

    private static int robIterativeUsingVariables(int[] nums) {
        if (nums.length == 0) return 0;
        int prev2 = 0;
        int prev1 = 0;
        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + num);
            prev2 = temp;
        }
        return prev1;
    }

    private static int robIterativeMemo(int[] arr) {
        if (arr.length == 0) return 0;
        dp = new int[arr.length + 1];
        dp[0] = 0;
        dp[1] = arr[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[arr.length];
    }

    public static int rob(int[] nums) {
        dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return rob(nums, nums.length - 1);
    }

    private static int rob(int[] nums, int i) {
        if (i < 0) return 0;
        if (dp[i] != -1) return dp[i];

        int less2 = rob(nums, i - 2);
        int less1 = rob(nums, i - 1);

        int res = Math.max(less2 + nums[i], less1);

        System.out.println(Arrays.toString(dp));

        return dp[i] = res;
    }
}
