package com.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class SWY {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];
        IntStream.range(0, arr.length).forEach(i -> arr[i] = random.nextInt(50));
        System.out.println(Arrays.toString(arr));
//        quickSWY(arr);
//        mergeSWY(arr);
//        selectionSWY(arr);
//        insertionSWY(arr);
        bubbleSWY(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSWY(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swappIt(arr, i, j);
                }
            }
        }
    }

    private static void insertionSWY(int[] arr) {
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

    private static void selectionSWY(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minPosition = i;
            int minVal = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minVal) minPosition = j;
            }
            if (minPosition != i) swappIt(arr, minPosition, i);
        }
    }

    private static void mergeSWY(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[arr.length - mid];

        IntStream.range(0, mid).forEach(i -> leftArray[i] = arr[i]);
        IntStream.range(mid, arr.length).forEach(i -> rightArray[i - mid] = arr[i]);

        mergeSWY(leftArray);
        mergeSWY(rightArray);

        mergeChunksSWY(arr, leftArray, rightArray);
    }

    private static void mergeChunksSWY(int[] arr, int[] leftArray, int[] rightArray) {
        int i = 0, k = 0, j = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) arr[k++] = leftArray[i++];
            else arr[k++] = rightArray[j++];
        }

        while (i < leftArray.length) arr[k++] = leftArray[i++];
        while (j < rightArray.length) arr[k++] = rightArray[j++];
    }

    private static void quickSWY(int[] arr) {
        quickSWY(arr, 0, arr.length - 1);
    }

    private static void quickSWY(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;
        //Choosing PIVOT
        int pivot = arr[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (pivot > arr[leftPointer] && leftPointer < rightPointer) leftPointer++;
            while (pivot <= arr[rightPointer] && leftPointer < rightPointer) rightPointer--;
            swappIt(arr, leftPointer, rightPointer);
        }
        swappIt(arr, leftPointer, highIndex);

        quickSWY(arr, lowIndex, leftPointer - 1);
        quickSWY(arr, leftPointer + 1, highIndex);

    }

    private static void swappIt(int[] inputArray, int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;
    }
}
