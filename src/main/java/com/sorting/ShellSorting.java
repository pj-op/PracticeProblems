package com.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ShellSorting {
    static int pass = 0;

    public static void main(String[] args) {
        int[] arr = new int[16];
        Random random = new Random();
        IntStream.range(0, arr.length).forEach(i -> arr[i] = random.nextInt(100));
        System.out.println(Arrays.toString(arr));
//        shellSortingAlgo(arr);
        insertionSortAlgoModified(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSortAlgoModified(int[] arr) {
        int n = arr.length;
        int gap = n / 2;

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int minVal = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > minVal) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = minVal;
            }
            gap /= 2;
        }
    }

    private static void insertionSortAlgo(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int minVal = arr[i];
            while (j >= 0 && arr[j] > minVal) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = minVal;
        }
    }

    private static void shellSortingAlgo(int[] arr) {
        int n = arr.length;
        int gap = n / 2;

        while (gap > 0) {
            for (int i = 0; i < n; ) {
                if (i + gap < n && arr[i] > arr[i + gap]) {
                    swappingElements(arr, i, i + gap);
                }
                i += gap;
            }
            System.out.println(Arrays.toString(arr));
            pass++;
            gap /= 2;
        }
    }

    private static void iterateAndPrint(int n, int gap) {
        if (gap == 0) return;
        for (int i = 0; i < n; i += gap) {
            System.out.print(i + " ");
        }
        System.out.println();
        iterateAndPrint(n, gap / 2);
    }

    private static void swappingElements(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
