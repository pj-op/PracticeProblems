package com.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.IntStream;

public class MinimumOperationsReduceXZero {
    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;
        System.out.println(minOperations(nums, x));
    }

    public static int minOperations(int[] nums, int x) {
        int totalSum = Arrays.stream(nums).sum();
        if (nums.length == x) return nums.length;
        if (nums.length < x) return -1;

        int rest_sum = totalSum - x;
        int sum = 0;
        int start = 0;
        int end = 0;
        int ans = 0;
        //Sliding window variation
        while (end < nums.length) {
            sum += nums[end];
            while (sum > rest_sum) {
                sum -= nums[start++];
            }
            if (sum == rest_sum) {
                ans = Math.max(ans, end - start + 1);
            }
            end++;
        }
        return ans == 0 ? -1 : nums.length - ans;
    }
}
