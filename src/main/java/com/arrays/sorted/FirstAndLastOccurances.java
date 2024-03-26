package com.arrays.sorted;

import java.util.Arrays;

public class FirstAndLastOccurances {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 4, 4, 5, 6, 6, 6, 6};
        int target = 2;
        System.out.println(findFirstAndLastIndex(arr, target));
    }

    private static int findFirstAndLastIndex(int[] arr, int target) {
        int[] res = {-1, -1};
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == arr[mid]) {
                res[0] = mid;
                high = mid - 1;
            } else if (target < arr[mid]) high = mid - 1;
            else low = mid + 1;
        }
        low = 0;
        high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == arr[mid]) {
                res[1] = mid;
                low = mid + 1;
            } else if (target < arr[mid]) high = mid - 1;
            else low = mid + 1;
        }

        System.out.println(Arrays.toString(res));

        return 0;
    }
}
