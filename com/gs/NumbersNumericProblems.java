package com.gs;

public class NumbersNumericProblems {
    public static void main(String[] args) {
//        1. Smallest Number
        int arr[] = {3, 4, 5, 6, 1, 2};
//        System.out.println(getSmallestNumberUsingBinarySerach(arr));

//        2. Second Smallest
        int inputArr[] = {1, 2, 3, 4, 5, 6, 7};
//        System.out.println(getSecondSmallestNumber(inputArr));

    }

    private static int getSecondSmallestNumber(int[] inputArr) {
        int first = 0, second = 0;
        first = second = Integer.MAX_VALUE;

        for (int num : inputArr) {
            if (num < first) {
                second = first;
                first = num;
            } else if (second > num && first != num) {
                second = num;
            }
        }
        return second;
    }

    private static int getSmallestNumberUsingBinarySerach(int[] arr) {
        int low = 0, high = arr.length - 1, mid = 0, n = arr.length;

        while (low <= high) {

            mid = (low + high) / 2;

            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;

            if (arr[low] < arr[high]) return arr[low];
            else if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) return arr[mid];

            if (arr[mid] >= arr[low]) low = mid + 1;
            else if (arr[mid] <= arr[high]) high = mid - 1;


        }


        return 0;
    }


}
