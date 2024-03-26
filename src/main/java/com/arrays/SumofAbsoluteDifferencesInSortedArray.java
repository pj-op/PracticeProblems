package com.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SumofAbsoluteDifferencesInSortedArray {
    public static void main(String[] args) {
        int[] nums =
                {1, 4, 6, 8, 10};
//                {2, 3, 5};
        System.out.println(Arrays.toString(getSumAbsoluteDifferencesOptimal(nums)));
    }

    private static int[] getSumAbsoluteDifferencesOptimal(int[] nums) {
        int leftSum = 0;
        int totalSum = 0;
        int n = nums.length;

        for (int ele : nums) totalSum += ele;

        for (int i = 0; i < nums.length; i++) {
            int valLeft = (nums[i] * i) - leftSum;
            System.out.println(valLeft);
            int valRight = totalSum - leftSum - (nums[i] * (n - i));
            System.out.println(valRight);
            leftSum += nums[i];
            System.out.println(leftSum);
            nums[i] = valLeft + valRight;
        }
        return nums;
    }

    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                ans[i] += Math.abs(nums[i] - nums[j]);
            }
        }
        return ans;
    }
}
