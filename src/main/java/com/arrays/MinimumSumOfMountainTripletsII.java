package com.arrays;

public class MinimumSumOfMountainTripletsII {
    public static void main(String[] args) {
        int[] nums = {8, 6, 1, 5, 3};
        System.out.println(minimumSum(nums));
    }

    public static int minimumSum(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;

        int[] leftMinArr = new int[n];
        leftMinArr[0] = nums[0];
        //Calculate minPrefix
        for (int i = 1; i < n; i++) {
            leftMinArr[i] = Math.min(leftMinArr[i - 1], nums[i]);
        }

        int[] rightMinArr = new int[n];
        rightMinArr[n - 1] = nums[n - 1];
        //Calculate minSuffix
        for (int i = n - 2; i >= 0; i--) {
            rightMinArr[i] = Math.min(rightMinArr[i + 1], nums[i]);
        }

        for (int j = 1; j < n - 1; j++) {
            if (nums[j] > leftMinArr[j - 1] && nums[j] > rightMinArr[j + 1]) {
                ans = Math.min(ans, nums[j] + leftMinArr[j - 1] + rightMinArr[j + 1]);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
