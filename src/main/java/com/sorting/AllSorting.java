package com.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class AllSorting {
    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random random = new Random();
        IntStream.range(0, arr.length).forEach(i -> arr[i] = random.nextInt(10000));
        System.out.println(Arrays.toString(arr));
//        radixSort(arr);
//        countSort(arr);
//        bubbleSort(arr);
//        selectionSort(arr);
//        insertionSort(arr);
//        mergeSort(arr);
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[arr.length - mid];

        IntStream.range(0, mid).forEach(i -> leftArray[i] = arr[i]);
        IntStream.range(mid, arr.length).forEach(i -> rightArray[i - mid] = arr[i]);

        mergeSort(leftArray);
        mergeSort(rightArray);

        mergingArraysInSortedOrder(arr, leftArray, rightArray);
    }

    private static void countSort(int[] arr) {
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;

        for (int ele : arr) {
            minElement = Math.min(minElement, ele);
            maxElement = Math.max(maxElement, ele);
        }

        int[] freqArray = new int[maxElement - minElement + 1];

        int min = minElement;
        IntStream.range(0, arr.length).forEach(i -> freqArray[arr[i] - min]++);

        //PrefixSum
        IntStream.range(1, freqArray.length).forEach(i -> freqArray[i] = freqArray[i] + freqArray[i - 1]);

        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = freqArray[arr[i] - min] - 1;
            if (index >= 0) {
                ans[index] = arr[i];
                freqArray[arr[i] - min]--;
            }
        }
        System.arraycopy(ans, 0, arr, 0, arr.length);
    }

    private static void radixSort(int[] arr) {
        int maxElement = Integer.MIN_VALUE;
        for (int ele : arr) maxElement = Math.max(maxElement, ele);
        int exponent = 1;
        while (exponent <= maxElement) {
            countSorting(arr, exponent);
            exponent *= 10;
        }
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) swappingElement(arr, i, j);
            }
        }
    }

    private static void insertionSort(int[] arr) {
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

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minPosition = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minPosition]) minPosition = j;
            }
            if (i != minPosition) swappingElement(arr, i, minPosition);
        }
    }

    private static void countSorting(int[] arr, int exponent) {
        int[] freqArray = new int[10];
        //FreqArray
        IntStream.range(0, arr.length).forEach(i -> freqArray[arr[i] / exponent % 10]++);
        //Prefix sum of freqArray
        IntStream.range(1, freqArray.length).forEach(i -> freqArray[i] = freqArray[i] + freqArray[i - 1]);

        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = freqArray[arr[i] / exponent % 10] - 1;
            if (index >= 0) {
                ans[index] = arr[i];
                freqArray[arr[i] / exponent % 10]--;
            }
        }
        System.arraycopy(ans, 0, arr, 0, arr.length);
    }

    private static void quickSort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;
        int pivot = arr[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (pivot > arr[leftPointer] && leftPointer < rightPointer) leftPointer++;
            while (pivot <= arr[rightPointer] && leftPointer < rightPointer) rightPointer--;
            swappingElement(arr, leftPointer, rightPointer);
        }
        swappingElement(arr, leftPointer, highIndex);

        quickSort(arr, lowIndex, leftPointer - 1);
        quickSort(arr, leftPointer + 1, highIndex);
    }

    private static void swappingElement(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void mergingArraysInSortedOrder(int[] arr, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) arr[k++] = leftArray[i++];
            else arr[k++] = rightArray[j++];
        }
        while (i < leftArray.length) arr[k++] = leftArray[i++];
        while (j < rightArray.length) arr[k++] = rightArray[j++];
    }
}
