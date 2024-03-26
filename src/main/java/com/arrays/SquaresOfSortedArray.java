package com.arrays;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) nums[i] = nums[i] * nums[i];

        for (int i = 0; i < nums.length; i++) {
            int minPosition = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minPosition]) minPosition = j;
            }
            if (i != minPosition) swappingElements(nums, i, minPosition);
        }
        return nums;
    }

    private static void swappingElements(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }
}
