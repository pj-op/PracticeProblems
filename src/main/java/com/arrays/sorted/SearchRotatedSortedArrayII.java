package com.arrays.sorted;

public class SearchRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[low] == target || nums[high] == target || nums[mid] == target) return true;
            if (nums[low] == nums[mid] && nums[high] == nums[mid]) {
                low++;
                high--;
                continue;
            }
            //Left Sorted
            if (nums[mid] >= nums[low]) {
                if (target < nums[mid] && nums[low] <= target) high = mid - 1;
                else low = mid + 1;
            }
            //Right Sorted
            else {
                if (target > nums[mid] && nums[high] >= target) low = mid + 1;
                else high = mid - 1;
            }
        }
        return false;
    }
}
