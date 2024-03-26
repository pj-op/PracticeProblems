package com.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        /*Set<Integer> set = new HashSet<>();
        return Arrays.stream(nums)
                .filter(x -> !set.add(x))
                .findFirst().orElse(-1);*/
        boolean[] a = new boolean[nums.length + 1];
        for (int num : nums) {
            if (a[num]) return num;
            a[num] = true;
        }
        return -1;

    }
}
