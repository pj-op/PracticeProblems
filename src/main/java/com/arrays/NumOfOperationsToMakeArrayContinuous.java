package com.arrays;

import java.util.Arrays;

public class NumOfOperationsToMakeArrayContinuous {
    public static void main(String[] args) {
        int[] nums =
//                {4, 2, 5, 3}
                {8, 10, 16, 18, 10, 10, 16, 13, 13, 16};
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] original_array) {
        int org_arr_len = original_array.length;
        int[] mod_array = Arrays.stream(original_array).distinct().sorted().toArray();
        int end_index = 0;
        int len = mod_array.length;
        int max_len_window = Integer.MIN_VALUE;
        for (int start_index = 0; start_index < mod_array.length; start_index++) {
            while (end_index < len && mod_array[end_index] < mod_array[start_index] + org_arr_len) {
                end_index = end_index + 1;
            }
            max_len_window = Math.max(max_len_window, end_index - start_index);
        }
        return len - max_len_window;
    }
}
