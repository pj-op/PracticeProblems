package com.arrays;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trapOptimal(height));
    }

    private static int trapOptimal(int[] height) {
        int ans = 0;
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int leftBar = height[l];
        int rightBar = height[r];

        while (l < r) {
            if (leftBar <= rightBar) {
                ans += leftBar - height[l];
                l++;
                leftBar = Math.max(leftBar, height[l]);
            } else {
                ans += rightBar - height[r];
                r--;
                rightBar = Math.max(rightBar, height[r]);
            }
        }

        return ans;
    }

    private static int trap(int[] height) {
        AtomicInteger ans = new AtomicInteger();

        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = height[0];
        IntStream.range(1, n).forEach(idx -> left[idx] = Math.max(left[idx - 1], height[idx]));

        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        IntStream.range(0, n).forEach(idx -> ans.addAndGet(Math.min(left[idx], right[idx]) - height[idx]));

        return ans.get();
    }
}
