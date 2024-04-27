package com.GRAPH;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslandChar {
    public static void main(String[] args) {
        char[][] grid = {
                //Test Case : 1
                /*{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}*/
                //Test Case : 2
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfsUtility(i, j, grid, visited);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void bfsUtility(int row, int col, char[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pairing> queue = new LinkedList<>();
        queue.add(new Pairing(row, col));

        while (!queue.isEmpty()) {
            Pairing pairing = queue.remove();
            int nodePosRow = pairing.firstNode;
            int nodePosCol = pairing.secondNode;

            /*
            // Below loop is for 8 directions movement i.e. horizontally, vertically and diagonally
            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int nRow = nodePosRow + delRow;
                    int nCol = nodePosCol + delCol;

                    if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == '1' && !visited[nRow][nCol]) {
                        visited[nRow][nCol] = true;
                        queue.add(new Pairing(nRow, nCol));
                    }
                }
            }*/

            int[] delRowArr = {-1, 0, 1, 0};
            int[] delColArr = {0, 1, 0, -1};
            // Below loop is for 4 directions movement i.e. horizontally, vertically
            for (int i = 0; i < 4; i++) {
                int nRow = nodePosRow + delRowArr[i];
                int nCol = nodePosCol + delColArr[i];

                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == '1' && !visited[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    queue.add(new Pairing(nRow, nCol));
                }
            }
        }
    }
}

class Pairing {
    int firstNode;
    int secondNode;

    Pairing(int firstNode, int secondNode) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
    }
}
