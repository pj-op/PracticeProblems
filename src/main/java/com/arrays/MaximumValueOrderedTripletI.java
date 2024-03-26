package com.arrays;

//https://leetcode.com/contest/weekly-contest-365/problems/maximum-value-of-an-ordered-triplet-i/

import java.util.Arrays;

public class MaximumValueOrderedTripletI {
    public static void main(String[] args) {
        int[] nums =
//                {12, 6, 1, 2, 7}
                {1, 10, 3, 4, 19};
        System.out.println(maximumTripletValueOptimized(nums));
    }

    private static long maximumTripletValueOptimized(int[] nums) {
        long res = 0;
        int first = 0, diff = 0;

        for (int num : nums) {
            res = Math.max(res, (long) diff * num);
            diff = Math.max(diff, first - num);
            first = Math.max(first, num);
        }
        return res;
    }

    private static long maximumTripletValueOptimal(int[] nums) {
        //Calculate max prefix: nums[i] - nums[j]) * nums[k]
        int[] max_prefix = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            max_prefix[i] = nums[i];
            if (i > 0) max_prefix[i] = Math.max(max_prefix[i], max_prefix[i - 1]);
        }
        //Calculate max suffix: nums[i] - nums[j]) * nums[k]
        int[] max_suffix = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            max_suffix[i] = nums[i];
            if (i < nums.length - 1) max_suffix[i] = Math.max(max_suffix[i], max_suffix[i + 1]);
        }
        long ans = 0;
        for (int j = 1; j < nums.length - 1; j++) {
            ans = Math.max(ans, (long) (max_prefix[j - 1] - nums[j]) * max_suffix[j + 1]);
        }
        return ans;
    }

    public static long maximumTripletValue(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    ans = Math.max(ans, (long) (nums[i] - nums[j]) * nums[k]);
                }
            }
        }
        return ans;
    }
}
