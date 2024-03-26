package sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class QMISBSorts {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];
        IntStream.range(0, arr.length).forEach(i -> arr[i] = random.nextInt(200));
        System.out.println(Arrays.toString(arr));

//        quickSort2(arr);
//        mergeSort2(arr);
//        insertionSort2(arr);
        selectionSort2(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) swp(arr, i, minIndex);
        }
    }

    private static void insertionSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currVal = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > currVal) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = currVal;
        }
    }

    private static void mergeSort2(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[arr.length - mid];

        IntStream.range(0, mid).forEach(i -> leftArr[i] = arr[i]);
        IntStream.range(mid, arr.length).forEach(i -> rightArr[i - mid] = arr[i]);

        mergeSort2(leftArr);
        mergeSort2(rightArr);

        mergeChunks2(arr, leftArr, rightArr);
    }

    private static void mergeChunks2(int[] arr, int[] leftArr, int[] rightArr) {
        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) arr[k++] = leftArr[i++];
            else arr[k++] = rightArr[j++];
        }
        //leftOver elements either one of it will be executed
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    private static void quickSort2(int[] arr) {
        quickSort2(arr, 0, arr.length - 1);
    }

    private static void quickSort2(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;

        int pivot = arr[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (arr[leftPointer] < pivot && leftPointer < rightPointer) leftPointer++;
            while (arr[rightPointer] >= pivot && leftPointer < rightPointer) rightPointer--;
            swp(arr, leftPointer, rightPointer);
        }
        swp(arr, leftPointer, highIndex);

        quickSort2(arr, lowIndex, leftPointer - 1);
        quickSort2(arr, leftPointer + 1, highIndex);
    }

    private static void swp(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
