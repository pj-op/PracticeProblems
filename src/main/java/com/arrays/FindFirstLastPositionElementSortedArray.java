package com.arrays;

import java.util.Arrays;

public class FindFirstLastPositionElementSortedArray {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRangeUsingBinarySearch(nums, target)));
    }

    private static int[] searchRangeUsingBinarySearch(int[] nums, int target) {
        int[] res = {-1, -1};

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                res[0] = mid;
                high = mid - 1;
            } else if (target > nums[mid]) low = mid + 1;
            else if (target < nums[mid]) high = mid - 1;
        }
        low = 0;
        mid = 0;
        high = nums.length - 1;

        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                res[1] = mid;
                low = mid + 1;
            } else if (target > nums[mid]) low = mid + 1;
            else if (target < nums[mid]) high = mid - 1;
        }
        return res;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        Arrays.fill(ans, -1);

        int i = 0;
        int j = nums.length - 1;
        boolean flag1 = false;
        boolean flag2 = false;

        while (i < nums.length && j >= 0) {
            if (!flag1 && nums[i] == target) {
                flag1 = true;
                ans[0] = i;
            }
            if (!flag2 && nums[j] == target) {
                flag2 = true;
                ans[1] = j;
            }
            i++;
            j--;
        }
        return ans;
    }
}
