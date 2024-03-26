package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubarrays {
    public static void main(String[] args) {
//        int[] nums = {4, 6, 5, 9, 3, 7}, l = {0, 0, 2}, r = {2, 3, 5};
        int [] nums = {-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10}, l = {0, 1, 6, 4, 8, 7}, r = {4, 4, 9, 7, 9, 10};
        System.out.println(checkArithmeticSubarrays(nums, l, r));
    }

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        int len = l.length;
        List<Boolean> ans = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < len; i++) {
            int[] input = new int[r[i] - l[i] + 1];
            for (int j = l[i]; j <= r[i]; j++) {
//                System.out.print(nums[j] + " ");
                input[idx++] = nums[j];
            }
            ans.add(checkIsArithmeticSequence(input));
            idx = 0;
        }
        return ans;
    }

    private static Boolean checkIsArithmeticSequence(int[] input) {
        if (input.length <= 2) return true;
        Arrays.sort(input);
        System.out.println(Arrays.toString(input));
        for (int i = 1; i + 1 < input.length; i++) {
            if (input[i] - input[i - 1] != input[i + 1] - input[i]) {
                return false;
            }
        }
        return true;
    }
}
