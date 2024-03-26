package com.GRAPH;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfClosedIsland {
    public static void main(String[] args) {
//        int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
        int[][] grid = {
                {0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}
        };
        System.out.println(closedIsland(grid));
    }

    public static int closedIsland(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1 && !visited[i][j]) {
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        performBfsOnIsland(i, j, grid, visited, m, n);
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1 && !visited[i][j]) {
                    performBfsOnIsland(i, j, grid, visited, m, n);
                    count++;
                }
            }
        }

        return count;
    }

    private static void performBfsOnIsland(int row, int col, int[][] grid, boolean[][] visited, int m, int n) {
        Queue<NodePair> queue = new LinkedList<>();
        queue.add(new NodePair(row, col));
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            NodePair nodePair = queue.poll();
            int currRow = nodePair.getRow();
            int currCol = nodePair.getCol();

            int[] deltaRow = {-1, 0, 1, 0};
            int[] deltaCol = {0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int nRow = currRow + deltaRow[i];
                int nCol = currCol + deltaCol[i];

                if (nRow < m && nRow >= 0 && nCol < n && nCol >= 0 && !visited[nRow][nCol] && grid[nRow][nCol] == 0) {
                    queue.add(new NodePair(nRow, nCol));
                    visited[nRow][nCol] = true;
                }
            }
        }
    }

}

class NodePair {
    int row;
    int col;

    public NodePair(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public NodePair setRow(int row) {
        this.row = row;
        return this;
    }

    public int getCol() {
        return col;
    }

    public NodePair setCol(int col) {
        this.col = col;
        return this;
    }
}