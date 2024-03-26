package com.arrays;

import java.util.*;

public class SetMismatch {
    public static void main(String[] args) {
        int[] nums =
//                {1, 2, 2, 4};
//                {1, 1, 3, 4, 5, 5, 7};
//                {3, 2, 3, 4, 6, 5};
                {1, 5, 3, 2, 2, 7, 6, 4, 8, 9};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    private static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] result = new int[2];
        int[] freq = new int[n + 1];

        for (int num : nums) {
            freq[num]++;
        }

        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 2) {
                result[0] = i;
            }
            if (freq[i] == 0) {
                result[1] = i;
            }
        }

        return result;
    }
}
