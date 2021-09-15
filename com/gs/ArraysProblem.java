package com.gs;

import java.util.Arrays;

public class ArraysProblem {
    public static void main(String[] args) {
//        1. Median of two sorted Arrays
        int[] arr1 = {1, 3};
        int[] arr2 = {2, 4};
//        System.out.println(findMedianOfTwoSortedArrays(arr1, arr2));

//        2. Min SubArray length for given Sum
        int arr[] = {2, 3, 1, 2, 4, 3};
        int target = 7;
//        System.out.println(findMinArrayLength(arr, target));

//        PRACTICE: Merge Two sorted array
        int a[] = {1, 3, 4, 5};
        int b[] = {2, 4, 6, 8};

        System.out.println(Arrays.toString(getMergedArray(a, b)));


    }

    private static int[] getMergedArray(int[] a, int[] b) {
        int result[] = new int[a.length + b.length], i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[k] = a[i];
                i++;
                k++;
            } else {
                result[k] = b[j];
                j++;
                k++;
            }
        }
        while (i < a.length) {
            result[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            result[k] = b[j];
            j++;
            k++;
        }

        return result;
    }

    private static int findMinArrayLength(int[] arr, int target) {
        int sum = 0, minLength = Integer.MAX_VALUE, left = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            while (sum >= target) {
                minLength = Math.min(minLength, i - left + 1);
                sum = sum - arr[left];
                left++;
            }
        }

        return minLength < Integer.MAX_VALUE ? minLength : 0;

    }

    private static double findMedianOfTwoSortedArrays(int[] arr1, int[] arr2) {
//        1st way = Merge both arrays and return the median
//        2nd way = Using partition approach without merging them
        int low = 0, high = arr1.length, l1, l2, r1, r2, n1 = arr1.length, n2 = arr2.length;

        if (n1 > n2) return findMedianOfTwoSortedArrays(arr2, arr1);

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n1 + n2) / 2 - cut1;

            l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            r1 = cut1 == n1 ? Integer.MAX_VALUE : arr1[cut1];
            r2 = cut2 == n2 ? Integer.MAX_VALUE : arr2[cut2];

            if (l1 > r2) high = cut1 - 1;
            else if (l2 > r1) low = cut1 + 1;
            else return (n1 + n2) % 2 == 0 ? (Math.max(l1, l2) + Math.min(r1, r2)) / 2d : Math.min(r1, r2);
        }
        return 0;
    }
}
