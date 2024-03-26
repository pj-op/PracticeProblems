package com.arrays;

import java.util.Stack;

public class One132Pattern {
    public static void main(String[] args) {
        int[] nums =
//                {1, 2, 3, 4}
//                {3, 1, 4, 2}
                {-1, 3, 2, 0};
        System.out.println(find132pattern1(nums));
    }

    private static boolean find132pattern1(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                max = stack.pop();
            }
            if (nums[i] > max) stack.push(nums[i]);
            if (nums[i] < max) return true;
        }
        return false;
    }

    //This solution works for subArray not for subsequences
    public static boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        int i = 0;
        int j = i + 1;
        int k = j + 1;
        while (i < nums.length && j < nums.length && k < nums.length) {
            if (i < j && j < k && (nums[i] < nums[k] && nums[k] < nums[j])) {
                return true;
            }
            i++;
            j++;
            k++;
        }
        return false;
    }

}
