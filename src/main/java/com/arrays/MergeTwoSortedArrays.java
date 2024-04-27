package com.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 6, 8, 9};
        int[] arr2 = {2, 4, 5};
        mergedArrayOptimalI(arr1, arr2);
    }

    private static void mergedArrayOptimalI(int[] arr1, int[] arr2) {
        int left = arr1.length - 1;
        int right = 0;

        //O(n)
        while (left > right) {
            if (arr1[left] > arr2[right]) {
                swappingEle(arr1, arr2, left, right);
                left--;
                right++;
            }
        }
        //O(n log n)
        Arrays.sort(arr1);
        //O(n log n)
        Arrays.sort(arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }

    private static void mergedArrayBruteForceAg(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;

        int[] ans = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) ans[k++] = arr1[i++];
            else ans[k++] = arr2[j++];
        }
        while (i < arr1.length) ans[k++] = arr1[i++];
        while (j < arr2.length) ans[k++] = arr2[j++];

        System.out.println(Arrays.toString(ans));

    }

    private static void mergedArrayWithoutExtraSpace(int[] arr1, int[] arr2) {
        int right = 0;
        int left = arr1.length - 1;

        while (left >= 0 && right < arr2.length) {
            if (arr2[right] < arr1[left]) {
                swappingEle(arr1, arr2, left--, right++);
            } else break;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void swappingEle(int[] arr1, int[] arr2, int arr1Index, int arr2Index) {
        int temp = arr1[arr1Index];
        arr1[arr1Index] = arr2[arr2Index];
        arr2[arr2Index] = temp;
    }

    public static void mergedArrayBruteForce(int[] a, int[] b) {

        int[] result = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) result[k++] = a[i++];
            else result[k++] = b[j++];
        }
        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];

        System.out.println(Arrays.toString(result));

        IntStream.range(0, a.length).forEach(idx -> a[idx] = result[idx]);
        IntStream.range(0, b.length).forEach(idx -> b[idx] = result[idx + a.length]);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
