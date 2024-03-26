package com.arrays.matrix;

import java.util.Arrays;

public class DifferenceBetweenOnesZerosRowColumn {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1},
                {1, 0, 1},
                {0, 0, 1}
//                {1, 1, 1},
//                {1, 1, 1}
        };
        System.out.println(Arrays.deepToString(onesMinusZerosOptimal(grid)));
    }

    private static int[][] onesMinusZerosOptimal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];

        int[] rowSum = new int[m];
        int[] rowSumZero = new int[m];
        //Calculate row & col sum
        int[] colSum = new int[n];
        int[] colSumZero = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += grid[i][j];
                colSum[j] += grid[i][j];
                if (grid[i][j] == 0) rowSumZero[i]++;
                if (grid[i][j] == 0) colSumZero[j]++;
            }
        }

        System.out.println("rowSum: "+Arrays.toString(rowSum));
        System.out.println("rowSumZero: "+Arrays.toString(rowSumZero));
        System.out.println("colSum: "+Arrays.toString(colSum));
        System.out.println("colSumZero: "+Arrays.toString(colSumZero));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = rowSum[i] + colSum[j] - rowSumZero[i] - colSumZero[j];
            }
        }
        return ans;
    }

    public static int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] countZeroAndOne = new int[2];
                for (int k = 0; k < m; k++) {
                    countZeroAndOne[grid[k][j]]++;
                }
                for (int l = 0; l < n; l++) {
                    countZeroAndOne[grid[i][l]]++;
                }
                ans[i][j] = countZeroAndOne[1] - countZeroAndOne[0];
            }
        }
        return ans;
    }
}
