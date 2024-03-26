package com.arrays;

//https://leetcode.com/problems/find-the-difference-of-two-arrays/ ACCEPTED

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDifferenceOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 =
//                {1, 2, 3}
                {1, 2, 3, 3};
        int[] nums2 =
//                {2, 4, 6}
                {1, 1, 2, 2};
        System.out.println(findDifference(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());

        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        for (int a : set1) {
            if (!set2.contains(a)) {
                ans.get(0).add(a);
            }
        }
        for (int a : set2) {
            if (!set1.contains(a)) {
                ans.get(1).add(a);
            }
        }
        return ans;
    }
}
