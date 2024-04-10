package com.arrays;

public class SubArraysProductLessThanK {
    public static void main(String[] args) {
        int[] arr = {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
        int k = 19;
        System.out.println(numSubarrayProductLessThanKOptimal(arr, k));
    }

    private static int numSubarrayProductLessThanKOptimal(int[] nums, int k) {
        int n = nums.length;
        int j = 0;
        int i = 0;
        int count = 0;
        int prod = 1;

        while (j < n) {
            prod *= nums[j];
            while (prod >= k) {
                prod /= nums[i];
                i++;
            }
            count += (j - i + 1);
            j++;
        }
        return count;
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int prod = 1;
                for (int l = i; l <= j; l++) {
                    prod *= nums[l];
                    if (prod > k) break;
                }
                if (prod < k && prod > 0) {
                    System.out.println("PROD: " + prod);
                    count++;
                }
            }
        }
        return count;
    }
}
