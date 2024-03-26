package com.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class AllKindOfSorting {
    public static void main(String[] args) {
        int[] arr = new int[999];
        Random random = new Random();
        IntStream.range(0, arr.length).forEach(i -> arr[i] = random.nextInt(989898));
        System.out.println(Arrays.toString(arr));
//        bubbleSortt(arr);
//        insertSortt(arr);
//        selectionSortt(arr);
//        countSortt(arr);
//        radixSortt(arr);
//        mergeSortt(arr);
        quickSortt(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSortt(int[] arr) {
        quickSortt(arr, 0, arr.length - 1);
    }

    private static void quickSortt(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;
        int pivot = arr[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (arr[leftPointer] > pivot && leftPointer < rightPointer) leftPointer++;
            while (arr[rightPointer] <= pivot && leftPointer < rightPointer) rightPointer--;
            swapElements(leftPointer, rightPointer, arr);
        }
        swapElements(leftPointer, highIndex, arr);

        quickSortt(arr, lowIndex, leftPointer - 1);
        quickSortt(arr, leftPointer + 1, highIndex);

    }

    private static void mergeSortt(int[] arr) {

        if (arr.length < 2) return;

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        IntStream.range(0, mid).forEach(i -> left[i] = arr[i]);
        IntStream.range(mid, arr.length).forEach(i -> right[i - mid] = arr[i]);

        mergeSortt(left);
        mergeSortt(right);

        mergeChunksInSortedOrder(arr, left, right);

    }

    private static void mergeChunksInSortedOrder(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] > right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    private static void radixSortt(int[] arr) {
        int maxElement = Integer.MIN_VALUE;
        for (int ele : arr) {
            maxElement = Math.max(maxElement, ele);
        }
        int exponent = 1;
        while (exponent <= maxElement) {
            performCountingSort(arr, exponent);
            exponent *= 10;
        }
    }

    private static void performCountingSort(int[] arr, int exponent) {

        int[] freq = new int[10];
        int[] ans = new int[arr.length];

        for (int ele : arr) {
            freq[ele / exponent % 10]++;
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            freq[i] = freq[i] + freq[i + 1];
        }

        for (int ele : arr) {
            int index = freq[ele / exponent % 10] - 1;
            if (index >= 0) {
                ans[index] = ele;
                freq[ele / exponent % 10]--;
            }
        }
        System.arraycopy(ans, 0, arr, 0, arr.length);
    }

    private static void countSortt(int[] arr) {
        int[] ans = new int[arr.length];
        int maxElement = Integer.MIN_VALUE;
        int minElement = Integer.MAX_VALUE;

        for (int ele : arr) {
            maxElement = Math.max(ele, maxElement);
            minElement = Math.min(ele, minElement);
        }

        //Creating FreqArray
        int[] freqArray = new int[maxElement - minElement + 1];
        for (int ele : arr) {
            freqArray[ele - minElement]++;
        }
        //Suffix Sum of freqArray
        for (int i = freqArray.length - 2; i >= 0; i--) {
            freqArray[i] = freqArray[i] + freqArray[i + 1];
        }

        for (int ele : arr) {
            int index = freqArray[ele - minElement] - 1;
            if (index >= 0) {
                ans[index] = ele;
                freqArray[ele - minElement]--;
            }
        }

        System.arraycopy(ans, 0, arr, 0, arr.length);

    }

    private static void selectionSortt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int maxPosition = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxPosition]) maxPosition = j;
            }
            if (maxPosition != i) swapElements(i, maxPosition, arr);
        }
    }

    private static void insertSortt(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int maxVal = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < maxVal) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = maxVal;
        }
    }

    private static void bubbleSortt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) swapElements(i, j, arr);
            }
        }
    }

    private static void swapElements(int fIndex, int sIndex, int[] arr) {
        int temp = arr[fIndex];
        arr[fIndex] = arr[sIndex];
        arr[sIndex] = temp;
    }
}
