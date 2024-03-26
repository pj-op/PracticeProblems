package com.arrays;

import java.util.Arrays;

public class MaximumElementAfterDecreasingRearranging {
    public static void main(String[] args) {
        int[] arr =
                {1, 2, 3, 4, 5};
//                {2, 2, 1, 2, 1};
//                {100, 1, 1000};
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int maxElement = Integer.MIN_VALUE;
        Arrays.sort(arr);
        arr[0]=1;
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) <= 1) {
                continue;
            } else {
                arr[i] = arr[i - 1] + 1;
            }
        }
        for (int ele : arr) maxElement = Math.max(maxElement, ele);
        return maxElement;
    }
}
