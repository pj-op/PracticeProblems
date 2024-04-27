package com.arrays;

public class JumpGame2 {
    public static void main(String[] args) {
        int[] ar = {2, 3, 1, 1, 4};
        System.out.println(jump(ar));
    }

    public static int jump(int[] nums) {
        int result = 0;
        int count = 0;
        int reach = nums[0];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + nums[i];
        }
        for (int i = 0; i < reach; i++) {
            reach = Math.max(reach, nums[i]);
            if (reach >= nums.length) {
                result++;
            }
        }
        System.out.println(result);
        return Math.max(result, count);
    }
}
