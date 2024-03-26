
package com.GRAPH.graphpractice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrixTraversal {
    public static void main(String[] args) {
        int[][] mat = {
                /*{0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}*/

                {0,0,0},{0,1,0},{1,1,1}
        };
        System.out.println(Arrays.deepToString(updateMatrix(mat)));
    }

    public static int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        Queue<ZeroOneMtx> queue = new LinkedList<>();

        int[][] ans = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    queue.add(new ZeroOneMtx(i, j, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            ZeroOneMtx currNode = queue.poll();
            int currRow = currNode.row;
            int currCol = currNode.col;
            int currStep = currNode.step;
            ans[currRow][currCol] = currStep;

            for (int i = 0; i < delRow.length; i++) {
                int cRow = currRow + delRow[i];
                int cCol = currCol + delCol[i];

                if (cRow >= 0 && cCol >= 0 && cRow < n && cCol < m && !visited[cRow][cCol] && grid[cRow][cCol] == 1) {
                    visited[cRow][cCol] = true;
                    queue.add(new ZeroOneMtx(cRow, cCol, currStep + 1));
                }

            }
        }
        return ans;
    }
}


class ZeroOneMtx {
    int row;
    int col;
    int step;

    public ZeroOneMtx(int row, int col, int step) {
        this.row = row;
        this.col = col;
        this.step = step;
    }
}
