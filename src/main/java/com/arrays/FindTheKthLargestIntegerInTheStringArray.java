package com.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class FindTheKthLargestIntegerInTheStringArray {
    public static void main(String[] args) {
        int n = 4;
        String[] nums = {"3", "6", "7", "10"};
        System.out.println(kthLargestNumber(nums, n));
    }

    public static String kthLargestNumber(String[] nums, int k) {

        Arrays.sort(nums, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) return o1.length() - o2.length();
                return o1.compareTo(o2);
            }
        });

        System.out.println(Arrays.toString(nums));

        return nums[nums.length - k];
    }
}
