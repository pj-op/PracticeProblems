package com.arrays;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums =
//                {1, 1, 2}
                {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicatesII(nums));
    }

    private static int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                System.out.println(true);
                nums[j] = nums[i + 1];
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }

    private static int removeDuplicatesII(int[] nums) {
        int j = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[j - 2]) {
                nums[j] = nums[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }

}
