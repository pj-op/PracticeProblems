package com.arrays;

import java.util.Arrays;

public class SortArrayByPairity {
    public static void main(String[] args) {
        int[] nums =
//                {2, 4, 1, 3}
                {3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }

    private static int[] sortArrayByParityOptimal(int[] nums) {

        for (int i = 0, j = 0; i < nums.length; j++) {
            if (nums[j] % 2 == 0) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }

    public static int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = i + 1;
        while (i < nums.length && j < nums.length) {
            if (nums[i] % 2 == 0) {
                i++;
                j = i;
                continue;
            }
            while (j < nums.length && nums[j] % 2 == 0 && nums[i] % 2 != 0) {
                swappElements(nums, i, j);
                i++;
                j++;
            }
            j++;
        }
        return nums;
    }

    private static void swappElements(int[] inputArray, int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;
    }
}
