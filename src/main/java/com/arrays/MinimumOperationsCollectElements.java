package com.arrays;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumOperationsCollectElements {
    public static void main(String[] args) {
//        List<Integer> nums = List.of(3, 1, 5, 4, 2);int k = 2;
        List<Integer> nums = List.of(3, 1, 5, 4, 2); int k = 5;
//        List<Integer> nums = List.of(3, 2, 5, 3, 1);int k = 3;
//        List<Integer> nums = List.of(1, 2, 2);int k = 2;
        System.out.println(minOperationsOptimal(nums, k));
    }

    private static int minOperationsOptimal(List<Integer> nums, int k) {
        int n = nums.size();
        boolean[] marked = new boolean[k + 1];
        int markedCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            int num = nums.get(i);
            if (num <= k && !marked[num]) {
                marked[num] = true;
                markedCount++;
            }
            if (markedCount == k) return n - i;
        }
        return -1;
    }

    public static int minOperations(List<Integer> nums, int k) {
        int count = k;
        Set<Integer> set = new HashSet<>();
        for (int i = nums.size() - 1; i >= 0; i--) {
            int num = nums.get(i);
            if (set.contains(num)) continue;
            else {
                set.add(num);
                if (num <= k) {
                    count--;
                    if (count == 0) return nums.size() - i;
                }
            }
        }
        return -1;
    }
}
