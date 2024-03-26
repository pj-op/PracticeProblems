package com.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DivideArrayIntoArraysWithMaxDifference {
    public static void main(String[] args) {
        int[] nums =
//                {1, 3, 3, 2, 7, 3};
                {1, 3, 4, 8, 7, 9, 3, 5, 1};
        int k = 2;
        System.out.println(Arrays.deepToString(divideArray(nums, k)));
    }

    public static int[][] divideArray(int[] nums, int k) {
        boolean flag = false;
        int n = nums.length;
        int[][] ans = new int[n / 3][3];
        Arrays.sort(nums);

        int row = 0;

        for (int i = 1; i + 1 < n; ) {
            if (nums[i] - nums[i - 1] <= k && nums[i + 1] - nums[i - 1] <= k) {
                ans[row][0] = nums[i - 1];
                ans[row][1] = nums[i];
                ans[row][2] = nums[i + 1];
                row++;
            } else {
                flag = true;
            }
            i += 3;
        }
        return flag ? new int[][]{} : ans;
    }
}
