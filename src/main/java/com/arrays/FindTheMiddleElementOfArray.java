package com.arrays;

public class FindTheMiddleElementOfArray {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 5, 6, 8, 9, 9};

        int n = arr.length;
        int slowPointer = 0;
        int fastPointer = 0;

        while (fastPointer < n) {
            slowPointer++;
            fastPointer += 2;
        }
        System.out.println(arr[slowPointer - 1]);
        System.out.println(arr[fastPointer - 1]);

    }
}
