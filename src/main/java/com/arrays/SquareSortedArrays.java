package com.arrays;

import java.util.Arrays;

public class SquareSortedArrays {
    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 2, 3, 5};
        System.out.println(Arrays.toString(sortSquareArray(arr)));
    }

    private static int[] sortSquareArray(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int i = 0;
        int j = arr.length - 1;
        int index = n - 1;

        while (i <= j) {
            int iVal = arr[i] * arr[i];
            int jVal = arr[j] * arr[j];
            if (iVal > jVal) {
                ans[index] = iVal;
                i++;
            } else {
                ans[index] = jVal;
                j--;
            }
            index--;
        }

        return ans;
    }
}
