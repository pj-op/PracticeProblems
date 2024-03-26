package com.arrays;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class BinarySearchTest {
    public static void main(String[] args) {
        Random random = new Random();
        int[] testCase = new int[10];
        for (int i = 0; i < testCase.length; i++) {
            testCase[i] = random.nextInt(88888);
        }
        int numToSearch = testCase[random.nextInt(testCase.length - 1)];
        Instant start = Instant.now();
//        performingQuickSorting(testCase);
        performingMergeSorting(testCase);
//        performingBubbleSorting(testCase);
//        System.out.println("Sorted Array: " + Arrays.toString(testCase));
        System.out.println("Index of " + numToSearch + " is: " + performBinarySearch(testCase, numToSearch));
        System.out.println("Index of " + numToSearch + " is: " + Arrays.binarySearch(testCase, numToSearch));
        Instant end = Instant.now();
        System.out.println("Total time taken: " + Duration.between(start, end).toMillis());
    }

    private static void performingBubbleSorting(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray.length; j++) {
                if (i == j) continue;
                if (inputArray[i] <= inputArray[j]) {
                    swappIt(inputArray, i, j);
                }
            }
        }
    }

    private static void performingMergeSorting(int[] inputArray) {
        if (inputArray.length <= 1) return;
        int n = inputArray.length;
        int midIndex = n / 2;
        int[] leftArray = new int[midIndex];
        int[] rightArray = new int[n - midIndex];

        Arrays.setAll(leftArray, i -> inputArray[i]);
        IntStream.range(midIndex, n).forEach(i -> rightArray[i - midIndex] = inputArray[i]);

        performingQuickSorting(leftArray);
        performingQuickSorting(rightArray);

        mergeChunk(inputArray, leftArray, rightArray);
    }

    private static void mergeChunk(int[] inputArray, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;
        int leftArrayLength = leftArray.length;
        int rightArrayLength = rightArray.length;

        while (i < leftArrayLength && j < rightArrayLength) {
            if (leftArray[i] <= rightArray[j]) {
                inputArray[k++] = leftArray[i++];
            } else {
                inputArray[k++] = rightArray[j++];
            }
        }

        while (i < leftArrayLength) {
            inputArray[k++] = leftArray[i++];
        }
        while (j < rightArrayLength) {
            inputArray[k++] = rightArray[j++];
        }
    }

    private static int performBinarySearch(int[] testCase, int k) {
        int low = 0;
        int high = testCase.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (testCase[mid] == k) return mid;
            if (testCase[mid] <= k) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    private static void performingQuickSorting(int[] testCase) {
        performingQuickSorting(testCase, 0, testCase.length - 1);
    }

    private static void performingQuickSorting(int[] inputArray, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;
        int pivot = inputArray[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (inputArray[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (inputArray[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swappIt(inputArray, leftPointer, rightPointer);
        }
        swappIt(inputArray, leftPointer, highIndex);

        performingQuickSorting(inputArray, lowIndex, leftPointer - 1);
        performingQuickSorting(inputArray, leftPointer + 1, highIndex);
    }

    private static void swappIt(int[] inputArray, int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;
    }

}
