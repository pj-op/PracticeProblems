package com.arrays;

import java.util.List;
import java.util.stream.IntStream;

public class KthMissingPoitiveNumber {
    public static void main(String[] args) {
        int[][] testCases = {{1, 2, 3, 4}, {2, 3, 4, 7, 11}};
        int[] k = {2, 5};
        int i = 0;
        for (int[] a : testCases) {
            System.out.println(findKthPositive(a, k[i++]));
        }
    }

    public static int findKthPositive(int[] arr, int k) {
        int count = 0;
        List<Integer> integerList = IntStream.rangeClosed(1, arr[arr.length - 1] + k).boxed().toList();
        int i = 0;
        for (int a : integerList) {
            while (i < arr.length) {
                int x = arr[i++];
                if (integerList.contains(x)) {
                    integerList.iterator().remove();
                }
            }
        }

        System.out.println(integerList);

        return 0;
    }
}
