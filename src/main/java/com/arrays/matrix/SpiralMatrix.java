package com.arrays.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] testCase = {

                /*{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}*/


                /*{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}*/

                /*{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}*/

                /*{1,2},
                {3,4}*/

//                {1}
        };

        System.out.println(printSpiralMatrix(testCase));
    }

    private static List<Integer> printSpiralMatrix(int[][] testCase) {
        List<Integer> spiral = new ArrayList<>();

        if (testCase.length == 0) return spiral;

        int m = testCase.length;
        int n = testCase[0].length;
        int total = m * n;
        int minCol = 0;
        int minRow = 0;
        int maxCol = n - 1;
        int maxRow = m - 1;

        while (total > 0) {
            for (int i = minCol; i <= maxCol && total > 0; i++) {
                spiral.add(testCase[minRow][i]);
                total--;
            }
            minRow++;
            for (int i = minRow; i <= maxRow && total > 0; i++) {
                spiral.add(testCase[i][maxCol]);
                total--;
            }
            maxCol--;
            for (int i = maxCol; i >= minCol && total > 0; i--) {
                spiral.add(testCase[maxRow][i]);
                total--;
            }
            maxRow--;
            for (int i = maxRow; i >= minRow && total > 0; i--) {
                spiral.add(testCase[i][minCol]);
                total--;
            }
            minCol++;
        }

        return spiral;
    }
}
