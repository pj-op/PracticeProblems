package com.GRAPH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/01-matrix/description/ : ACCEPTED

public class ZeroOneMatrix {
    public static void main(String[] args) {

        int[][] grid = {
                //TEST CASE : 1
                /*{1, 0, 1},
                {1, 1, 0},
                {1, 0, 0}*/

                //TEST CASE : 2
                {0, 0, 0},
                {0, 1, 0},
                {1, 0, 1}
        };

        int n = grid.length;
        int m = grid[0].length;
        int[] delRowArr = {-1, 0, 1, 0};
        int[] delColArr = {0, 1, 0, -1};

        boolean[][] visited = new boolean[n][m];
        int[][] stepArray = new int[n][m];
        Queue<XYZ> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {   //LEET CODE :  0
                    queue.add(new XYZ(i, j, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            int firstNodeCoordinate = queue.peek().firstNodePosition;
            int secondNodeCoordinates = queue.peek().secondNodePosition;
            int step = queue.peek().step;
            stepArray[firstNodeCoordinate][secondNodeCoordinates] = step;
            queue.remove();

            for (int i = 0; i < 4; i++) {
                int nRow = firstNodeCoordinate + delRowArr[i];
                int nCol = secondNodeCoordinates + delColArr[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 0 && !visited[nRow][nCol]) { //LEET CODE : 1
                    visited[nRow][nCol] = true;
                    queue.add(new XYZ(nRow, nCol, step + 1));
                }
            }

        }

        System.out.println(Arrays.deepToString(stepArray));

    }
}

class XYZ {
    int firstNodePosition;
    int secondNodePosition;
    int step;

    XYZ(int firstNodePosition, int secondNodePosition, int step) {
        this.firstNodePosition = firstNodePosition;
        this.secondNodePosition = secondNodePosition;
        this.step = step;
    }
}
