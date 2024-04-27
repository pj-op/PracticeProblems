package com.arrays;

import java.util.Arrays;
import java.util.Random;

public class FindLargestElement {
    public static void main(String[] args) {
        int[] arr = {71, 4, 15, 61, 51, 3, 15, 89, 78, 22};
        Random random = new Random();
//        IntStream.range(0, arr.length).forEach(i -> arr[i] = random.nextInt(100));
        System.out.println(Arrays.toString(arr));
        inserSort(arr);
        System.out.println(Arrays.toString(arr));
//                {3, 4, 5, 2};
//                {2, 4, 1, 3, 6, 8, 9};
//        System.out.println(naiveFindLargestElement(arr));
//        System.out.println(betterFindLargestElement(arr));
//        System.out.println(Arrays.toString(betterFindSecondLargestElement(arr)));

    }

    private static void inserSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int minVal = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > minVal) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = minVal;
        }
    }

    private static int[] betterFindSecondLargestElement(int[] arr) {
        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return new int[]{largest, secondLargest};
    }

    private static Integer naiveFindLargestElement(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }

    private static Integer betterFindLargestElement(int[] arr) {
        int largestNum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largestNum = Math.max(largestNum, arr[i]);
        }
        return largestNum;
    }
}
