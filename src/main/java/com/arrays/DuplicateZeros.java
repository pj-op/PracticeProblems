package com.arrays;

import java.util.Arrays;

public class DuplicateZeros {
    public static void main(String[] args) {
        int[] a = {1, 3, 0, 4, 0};
        System.out.println(Arrays.toString(duplicateZeros(a)));
    }

    public static int[] duplicateZeros(int[] arr) {
        int zeros = 0;

        for (int a : arr) if (a == 0) ++zeros;

        for (int i = arr.length - 1, j = arr.length + zeros - 1; i < j; --i, --j) {
            if (j < arr.length)
                arr[j] = arr[i];
            if (arr[i] == 0)
                if (--j < arr.length)
                    arr[j] = arr[i];
        }
        return arr;
    }
}
