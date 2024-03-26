package com.arrays.sorted;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 9;
        System.out.println(search(nums, target));

    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) return mid;
            else if (nums[mid] >= nums[low]) {
                if (nums[mid] > target && nums[low] <= target) high = mid - 1;
                else low = mid + 1;
            } else if (nums[mid] <= nums[high]) {
                if (nums[mid] < target && nums[high] >= target) low = mid + 1;
                else high = mid - 1;
            } else return -1;
        }
        return -1;
    }
}
