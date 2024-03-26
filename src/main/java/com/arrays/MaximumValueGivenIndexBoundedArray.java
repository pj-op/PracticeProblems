package com.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaximumValueGivenIndexBoundedArray {
    public static void main(String[] args) {
        int n = 6;
        int index = 1;
        int maxSum = 15;
        System.out.println(maxValue(n, index, maxSum));
    }

    public static int maxValue(int n, int index, int maxSum) {
        int[] ans = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ans[i];
            if (sum <= maxSum) {
                ans[i] = maxSum / n;
                n--;
            }
        }
        IntStream.range(ans.length / 2, ans.length).forEach(i -> ans[i] = ans[ans.length - 1 - i]);
        System.out.println(Arrays.toString(ans));
        return ans[index];
    }
}
