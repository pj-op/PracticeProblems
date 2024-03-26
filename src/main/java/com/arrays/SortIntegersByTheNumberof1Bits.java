package com.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class SortIntegersByTheNumberof1Bits {
    public static void main(String[] args) {
//        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        System.out.println(Arrays.toString(sortByBits(arr)));
    }

    public static int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(Integer::bitCount).thenComparing(Integer::intValue)).mapToInt(Integer::valueOf).toArray();
    }
}
