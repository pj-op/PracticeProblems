package com.GRAPH.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public static void main(String[] args) {
        int[][] grid = {
                // Test Case 1
                /*{0, 1, 0},
                {0, 0, 0},
                {0, 0, 1}*/

                // Test Case 2
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},


        };
        System.out.println(shortestBridge(grid));
    }

    private static int shortestBridge(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        //Introducing flag to run the DFS only once
        boolean flag = false;
        boolean[][] visited = new boolean[m][n];
        Queue<NodeRowCol> queue = new LinkedList<>();

        for (int i = 0; i < grid.length && !flag; i++) {
            for (int j = 0; j < grid[0].length && !flag; j++) {
                if (grid[i][j] == 1) {
                    performingDFSForBinGrid(i, j, visited, grid, queue);
                    flag = true;
                }
            }
        }
//        System.out.println(Arrays.deepToString(visited));
//        System.out.println(queue);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                NodeRowCol curNode = queue.poll();
                assert curNode != null;
                int currRow = curNode.getRow();
                int currCol = curNode.getCol();

                int[] delRow = {-1, 0, 1, 0};
                int[] delCol = {0, 1, 0, -1};

                for (int i = 0; i < delCol.length; i++) {
                    int nRow = delRow[i] + currRow;
                    int nCol = delCol[i] + currCol;

                    if (nRow >= 0 && nCol >= 0 && nRow < m && nCol < n && !visited[nRow][nCol]) {
                        if (grid[nRow][nCol] == 1) return level;
                        queue.add(new NodeRowCol(nRow, nCol));
                        visited[nRow][nCol] = true;
                    }
                }
            }
            level++;
        }

        return -1;
    }

    private static void performingDFSForBinGrid(int row, int col, boolean[][] visited, int[][] grid, Queue<NodeRowCol> queue) {
        visited[row][col] = true;
        int m = grid.length;
        int n = grid[0].length;

        queue.add(new NodeRowCol(row, col));

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for (int i = 0; i < delCol.length; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if (nRow < m && nRow >= 0 && nCol < n && nCol >= 0 && !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                performingDFSForBinGrid(nRow, nCol, visited, grid, queue);
            }
        }

    }

}

class NodeRowCol {
    int row;
    int col;

    NodeRowCol(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return "NodeRowCol{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
