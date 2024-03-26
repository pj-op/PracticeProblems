package com.arrays.matrix;

import java.util.Arrays;

public class DiagonalMatrixTraversal {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
                /*
                * [
                    [00, 01, 02, 03],
                    [10, 11, 12, 13],
                    [20, 21, 22, 23],
                    [30, 31, 32, 33]
                   ]
                * */
        };
        String str = "abbac";
        boolean[][] str_matrix = new boolean[str.length()][str.length()];
        String[][] str_matrix_1 = new String[str.length()][str.length()];

        System.out.println(Arrays.deepToString(makeDiagonalCall(str_matrix_1, str)));
        System.out.println(Arrays.deepToString(makeDiagStringCall(str_matrix, str)));
    }

    private static String[][] makeDiagonalCall(String[][] matrix, String str) {

        int n = matrix.length;
        int m = matrix[0].length;

        for (int gap = 0; gap < n; gap++) {
            for (int j = gap; j < m; j++) {
//                matrix[i][j] = i * 10 + j;
                matrix[gap][j] = str.substring(gap, j + 1);
            }
        }
        return matrix;
    }

    private static boolean[][] makeDiagStringCall(boolean[][] dp, String str) {
        int n = dp.length;
        int count = 0;
        int m = dp[0].length;
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < dp.length; i++, j++) {
                if (gap == 0) dp[i][j] = true;
                else {
                    var first_LastChar = str.charAt(i) == str.charAt(j);
                    if (gap == 1) {
                        dp[i][j] = first_LastChar;
                    } else {
                        dp[i][j] = first_LastChar && dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) count++;
            }
        }
        return dp;
    }
}
