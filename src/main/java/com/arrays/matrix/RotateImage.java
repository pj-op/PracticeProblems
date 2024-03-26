package com.arrays.matrix;

//https://leetcode.com/problems/rotate-image/ : ACCEPTED*

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                //Test Case
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
//        System.out.println(Arrays.deepToString(rotateMatrixWithExtraSpace(matrix)));
        System.out.println(Arrays.deepToString(rotateMatrixOptimal(matrix)));
    }

    private static int[][] rotateMatrixOptimal(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 1 - Transpose
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                swapMatrixIndex(matrix, i, j);
            }
        }

        for (int[] ints : matrix) {
            reverseArrayElements(ints);
        }

        return matrix;
    }

    private static void reverseArrayElements(int[] matrix) {
        int leftPointer = 0;
        int rightPointer = matrix.length - 1;

        while (leftPointer <= rightPointer) {
            int temp = matrix[leftPointer];
            matrix[leftPointer] = matrix[rightPointer];
            matrix[rightPointer] = temp;
            leftPointer++;
            rightPointer--;
        }
    }

    private static int[][] rotateMatrixWithExtraSpace(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = matrix[m - j - 1][i];
            }
        }
        return ans;
    }

    private static void swapMatrixIndex(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}