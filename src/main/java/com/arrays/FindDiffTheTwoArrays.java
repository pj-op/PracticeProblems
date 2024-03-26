package com.arrays;

import java.util.*;

public class FindDiffTheTwoArrays {
    public static void main(String[] args) {
        int[] nums1 =
//                {1, 2, 3};
                {1, 1, 2, 2};
        int[] nums2 =
//                {2, 4, 6};
                {1, 2, 3, 3};
        System.out.println(findDifference(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();

        Set<Integer> s1 = new HashSet<>();
        for (int num : nums1) s1.add(num);
        Set<Integer> s2 = new HashSet<>();
        for (int num : nums2) s2.add(num);

        for (int num : s1) {
            if (!s2.contains(num)) ans1.add(num);
        }
        for (int num : s2) {
            if (!s1.contains(num)) ans2.add(num);
        }
        return Arrays.asList(ans1, ans2);
    }
}
