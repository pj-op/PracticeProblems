package com.GRAPH;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int[][] grid = {
                //Test Case : 1
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
                //Test Case : 2
                /*{1, 1, 0, 0, 1}*/
                //Test Case : 3
                /*{1}*/
        };
        var newColor = 2;
        var m = grid.length;
        var n = grid[0].length;
        int[] delRowArr = {-1, 0, 1, 0};
        int[] delColArr = {0, 1, 0, -1};
        int[][] ans = grid;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && ans[i][j] != 2) {
                    dfsUtils(i, j, grid, ans, delRowArr, delColArr, newColor);
                }
            }
        }

        System.out.println(Arrays.deepToString(ans));

    }

    private static void dfsUtils(int row, int col, int[][] grid, int[][] ans, int[] delRowArr, int[] delColArr, int newColor) {
        int m = grid.length;
        int n = grid[0].length;
        ans[row][col] = newColor;
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRowArr[i];
            int nCol = col + delColArr[i];
            if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && ans[nRow][nCol] == 1) {
                ans[nRow][nCol] = newColor;
                dfsUtils(nRow, nCol, grid, ans, delRowArr, delColArr, newColor);
            }
        }
    }
}
