package com.arrays;

public class MonotonicArray {
    public static void main(String[] args) {
        int[] nums =
//                {1, 2, 2, 3}
//                {1, 3, 2}
//                {6, 5, 4, 4}
//                {1, 1, 1}
                {2, 2, 2, 1, 4, 5};
        System.out.println(isMonotonic(nums));
    }

    public static boolean isMonotonic(int[] nums) {
        int i = 0, j = i + 1, count1 = 0, count2 = 0, count3 = 0;
        boolean isIncreasing = false;
        boolean isDecreasing = false;
        boolean isEqual = false;

        while (i < nums.length && j < nums.length) {
            if (nums[i] <= nums[j] || nums[i] >= nums[j]) {
                if (nums[i] < nums[j]) {
                    isIncreasing = true;
                    count1++;
                }
                if (nums[i] > nums[j]) {
                    isDecreasing = true;
                    count2++;
                }
                if (isIncreasing && isDecreasing) return false;
                if (nums[i] == nums[j]) {
                    isEqual = true;
                    if (isIncreasing) count1++;
                    if (isDecreasing) count2++;
                }
                if (isEqual) {
                    count3++;
                }
            }
            i++;
            j++;
        }
        return count1 == nums.length - 1 || count2 == nums.length - 1 || count3 == nums.length - 1;
    }
}
