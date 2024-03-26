package com.arrays.matrix;

import java.util.Arrays;

public class FindMissingAndRepeatedValues {
    public static void main(String[] args) {
        int[][] grid = {{1, 3}, {2, 2}};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid)));
    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] ans = new int[2];
        int[] freqArray = new int[n * n];

//        int[] arr = Arrays.stream(grid).flatMapToInt(Arrays::stream).toArray();
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                freqArray[ints[j] - 1]++;

            }
        }
        for (int i = 0; i < freqArray.length; i++) {
            if (freqArray[i] == 0) ans[1] = i + 1;
            if (freqArray[i] > 1) ans[0] = i + 1;
        }
        return ans;
    }
}

