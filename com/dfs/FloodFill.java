package com.dfs;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int image[][] = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1;
        int newColor = 2;
        System.out.println(Arrays.deepToString((floodFill(image, sr, sc, newColor))));

    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private static void dfs(int[][] image, int row, int col, int color, int oldColor) {
        if (row >= image.length || row < 0 || col >= image[0].length || col < 0 || image[row][col] != oldColor) return;

        image[row][col] = color;

        dfs(image, row - 1, col, color, oldColor);
        dfs(image, row + 1, col, color, oldColor);
        dfs(image, row, col - 1, color, oldColor);
        dfs(image, row, col + 1, color, oldColor);
    }

}
