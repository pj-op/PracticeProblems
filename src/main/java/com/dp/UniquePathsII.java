package com.dp;

//https://leetcode.com/problems/unique-paths-ii/

import java.io.InputStream;
import java.util.Arrays;
import java.util.stream.IntStream;

public class UniquePathsII {
    static int paths = 0;
    static int[][] dp;

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
//        System.out.println(countUniquePaths(n, m));
//        System.out.println(uniquePathsWithObstacles(obstacleGrid));
//        System.out.println(uniquePathsWithObstaclesUsingDFS(obstacleGrid));
        System.out.println(uniquePathsWithObstaclesUsingDFSWithMemoization(obstacleGrid));
    }

    public static int countUniquePaths(int n, int m) {

        int[][] dp = new int[n][m];
        IntStream.range(0, n).forEach(i -> dp[i][0] = 1);
        IntStream.range(0, m).forEach(i -> dp[0][i] = 1);

//        System.out.println(Arrays.deepToString(dp));

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

//        System.out.println(Arrays.deepToString(dp));

        return dp[n - 1][m - 1];
    }

    //TC: 2(R*C)
    public static int uniquePathsWithObstaclesUsingDFS(int[][] grid) {
        dfsCheck(grid, 0, 0);
        return paths;
    }

    public static int uniquePathsWithObstaclesUsingDFSWithMemoization(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m];
        IntStream.range(0, n).forEach(i -> Arrays.fill(dp[i], -1));
        return dfsCheck1(grid, 0, 0);
    }

    public static int dfsCheck1(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == 1) return 0;
        if (row == grid.length - 1 && col == grid[0].length - 1) return 1;
        if (dp[row][col] != -1) return dp[row][col];
        dp[row][col] = dfsCheck1(grid, row + 1, col) + dfsCheck1(grid, row, col + 1);
        return dp[row][col];
    }

    public static void dfsCheck(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == 1) return;
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            paths++;
            return;
        }
        dfsCheck(grid, row + 1, col);
        dfsCheck(grid, row, col + 1);
    }
}
