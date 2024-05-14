package com.arrays.matrix;

public class CheckifGridSatisfiesConditions {
    public static void main(String[] args) {
        int[][] grid = {
                {1},
                {2},
                {3}
        };
        System.out.println(satisfiesConditions(grid));
    }

    private static boolean satisfiesConditions(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i + 1 < row) {
                    if (grid[i][j] != grid[i + 1][j]) {
                        return false;
                    }
                }
                if (j + 1 < col) {
                    if (grid[i][j] == grid[i][j + 1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
