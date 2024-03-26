package com.arrays;

import java.util.Arrays;

public class ShuffleTheArray {
    public static void main(String[] args) {
//        int[] nums = {2, 5, 1, 3, 4, 7}; int n = 3;
        int[] nums = {1, 2, 3, 4, 4, 3, 2, 1};int n = 4;

        System.out.println(Arrays.toString(shuffle(nums, n)));
    }

    public static int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0, j = 1; i * 2 < len && j <= n; i++, j++) {
            ans[i * 2] = nums[i];
            ans[i + j] = nums[i + n];
        }
        return ans;
    }
}
