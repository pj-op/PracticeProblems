package sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class SortingTechniques {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];
        IntStream.range(0, arr.length).forEach(i -> arr[i] = random.nextInt(100));
        System.out.println(Arrays.toString(arr));
//        insertionSorts(arr);
//        selectionSorts(arr);
        quickSorts(arr);
//        mergeSorts(arr);
//        bubbleSorts(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] bubbleSorts(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] >= arr[j]) swapElements(arr, i, j);
            }
        }
        return arr;
    }

    private static void mergeSorts(int[] arr) {
        if (arr.length < 2) return;
        int midIndex = arr.length / 2;
        int[] leftArray = new int[midIndex];
        int[] rightArray = new int[arr.length - midIndex];

        IntStream.range(0, midIndex).forEach(i -> leftArray[i] = arr[i]);
        IntStream.range(midIndex, arr.length).forEach(i -> rightArray[i - midIndex] = arr[i]);

        mergeSorts(leftArray);
        mergeSorts(rightArray);

        mergechunks(arr, leftArray, rightArray);
    }

    public static void mergechunks(int[] arr, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) arr[k++] = leftArray[i++];
            else arr[k++] = rightArray[j++];
        }
        while (i < leftArray.length) arr[k++] = leftArray[i++];
        while (j < rightArray.length) arr[k++] = rightArray[j++];
    }

    private static void quickSorts(int[] arr) {
        quickSorts(arr, 0, arr.length - 1);
    }

    private static void quickSorts(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;
        int pivot = arr[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (pivot <= arr[leftPointer] && leftPointer < rightPointer) leftPointer++;
            while (pivot >= arr[rightPointer] && leftPointer < rightPointer) rightPointer--;
            swapElements(arr, leftPointer, rightPointer);
        }
        swapElements(arr, leftPointer, highIndex);

        quickSorts(arr, lowIndex, leftPointer - 1);
        quickSorts(arr, leftPointer + 1, highIndex);

    }

    private static void insertionSorts(int[] inputArray) {
        for (int i = 1; i < inputArray.length; i++) {
            int minVal = inputArray[i];
            int j = i - 1;
            while (j >= 0 && inputArray[j] > minVal) {
                inputArray[j + 1] = inputArray[j];
                j--;
            }
            inputArray[j + 1] = minVal;
        }
    }

    private static void selectionSorts(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            int minPosition = i;
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[j] < inputArray[minPosition]) {
                    minPosition = j;
                }
            }
            if (minPosition != i) swapElements(inputArray, i, minPosition);
        }
    }

    private static void swapElements(int[] inputArray, int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;
    }
}
