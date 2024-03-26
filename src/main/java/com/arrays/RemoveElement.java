package com.arrays;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums =
                {2}
//                {3, 2, 2, 3}
//                {0, 1, 2, 2, 3, 0, 4, 2}
        ;
        int val = 2
//                2
                ;
        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 1 && nums[0] != val) return 0;
        int ans = 0;
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            if (nums[i] == val && nums[j] == val) {
                j--;
            } else if (nums[i] != val && nums[j] == val) {
                i++;
            } else if (nums[i] == val) {
                swapping(nums, i, j);
            }
        }

        for (int a: nums){
            if(a==val){
                break;
            }else {
                ans++;
            }
        }

        System.out.println(Arrays.toString(nums));

        return ans;
    }

    public static void swapping(int[] inputArr, int i, int j) {
        int temp = inputArr[i];
        inputArr[i] = inputArr[j];
        inputArr[j] = temp;
    }
}
