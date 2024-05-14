package com.arrays.matrix;

public class PathWithMaxGold {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}
        };
        System.out.println(getMaximumGold(grid));
    }

    private static int getMaximumGold(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int maxGold = Integer.MIN_VALUE;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, performDfs(grid, i, j));
                }
            }
        }

        return maxGold == Integer.MIN_VALUE ? 0 : maxGold;
    }

    private static int performDfs(int[][] grid, int row, int col) {

        int m = grid.length;
        int n = grid[0].length;

        int[] delRow = {-1, 1, 0, 0};
        int[] delCol = {0, 0, -1, 1};

        if (row >= m || row < 0 || col >= n || col < 0 || grid[row][col] == 0) {
            return 0;
        }

        int orgGold = grid[row][col];
        grid[row][col] = 0;
        int goldSofar = 0;

        for (int i = 0; i < delRow.length; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            goldSofar = Math.max(goldSofar, performDfs(grid, nRow, nCol));
        }

        grid[row][col] = orgGold;
        return orgGold + goldSofar;
    }
}
