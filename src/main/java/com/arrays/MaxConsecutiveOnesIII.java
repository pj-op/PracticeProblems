package com.arrays;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, n = nums.length, countOfZeros = 0, ans = Integer.MIN_VALUE;

        while (j < n) {
            if (nums[j] == 0) countOfZeros++;
            while (countOfZeros > k) {
                if (nums[i] == 0) countOfZeros--;
                i++;
            }
            j++;
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
