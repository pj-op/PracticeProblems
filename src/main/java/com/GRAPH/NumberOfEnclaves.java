package com.GRAPH;

//https://leetcode.com/problems/number-of-enclaves/

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public static void main(String[] args) {

        int[][] grid = {
                //TEST CASE :1
                /*{0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}*/
                //TEST CASE :2
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };

        int n = grid.length;
        int m = grid[0].length;
        Queue<Pairs1> queue = new LinkedList<>();
        boolean[][] visitedArray = new boolean[n][m];
        int[] delRowArray = {-1, 0, 1, 0};
        int[] delColArray = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visitedArray[i][j] && grid[i][j] == 1) {
                    if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                        queue.add(new Pairs1(i, j));
                        visitedArray[i][j] = true;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            queue.remove();

            for (int i = 0; i < 4; i++) {
                int nRow = row + delRowArray[i];
                int nCol = col + delColArray[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && !visitedArray[nRow][nCol]) {
                    visitedArray[nRow][nCol] = true;
                    queue.add(new Pairs1(nRow, nCol));
                }

            }
        }

        var count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visitedArray[i][j] && grid[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

class Pairs1 {
    int row;
    int col;

    Pairs1(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
