package com.dp;

//https://leetcode.com/problems/constrained-subsequence-sum/?envType=daily-question&envId=2023-10-21

import java.util.*;
import java.util.stream.Stream;

public class ConstrainedSubsequenceSum {
    public static void main(String[] args) {
        int[] nums =
//                {-1, -2, -3};
                {10, 2, -10, 5, 20};
        int k = 2;
        System.out.println(constrainedSubsetSum(nums, k));
    }

    public static int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        heap.add(new int[]{nums[0], 0});
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            while (!heap.isEmpty() && i - heap.peek()[1] > k) {
                heap.remove();
            }
            int curr = Math.max(0, heap.peek()[0]) + nums[i];
            ans = Math.max(ans, curr);
            heap.add(new int[]{curr, i});
        }
        return ans;
    }
}
