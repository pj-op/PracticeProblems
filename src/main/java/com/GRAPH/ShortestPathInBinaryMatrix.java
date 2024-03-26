package com.GRAPH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {

                /*{0, 1},
                {1, 0},*/

                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 0}

                /*{0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}*/
        };

        System.out.println(shortestPathBinaryMatrix(grid));

    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] destination = new int[n][m];
        Arrays.stream(destination).forEach(i -> Arrays.fill(i, Integer.MAX_VALUE));
        if (grid[0][0] != 0) return -1;
        if (m == 1 && n == 1) return 1;
        return bfsForShortest(0, 0, destination, grid, n - 1, m - 1);
    }

    private static int bfsForShortest(int row, int col, int[][] destination, int[][] grid, int destRow, int destCol) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<RCPair> queue = new LinkedList<>();
        queue.add(new RCPair(row, col, 1));
        destination[row][col] = 0;

        int[] delRowArray = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] delColArray = {-1, 0, 1, -1, 1, 1, 0, -1};

        while (!queue.isEmpty()) {
            RCPair currNode = queue.poll();
            int curRow = currNode.getR();
            int curCol = currNode.getC();
            int dist = currNode.getDistance();

            for (int i = 0; i < delRowArray.length; i++) {
                int nRow = curRow + delRowArray[i];
                int nCol = curCol + delColArray[i];

                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == 0 && dist + 1 < destination[nRow][nCol]) {
                    destination[nRow][nCol] = dist + 1;
                    if (nRow == destRow && nCol == destCol) {
                        return dist + 1;
                    }
                    queue.add(new RCPair(nRow, nCol, dist + 1));
                }
            }
        }
        return -1;
    }

    private static void dfsForShortest(int row, int col, boolean[][] visited, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        visited[row][col] = true;
        grid[row][col] = 2;

        int[] delRowArray = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] delColArray = {-1, 0, 1, -1, 1, 1, 0, -1};

        for (int i = 0; i < delRowArray.length; i++) {
            int nRow = row + delRowArray[i];
            int nCol = col + delColArray[i];

            if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && !visited[nRow][nCol] && grid[nRow][nCol] == 0) {
                dfsForShortest(nRow, nCol, visited, grid);
            }

        }

    }
}

class RCPair {
    int r;
    int c;
    int distance;

    public RCPair(int row, int col, int distance) {
        this.r = row;
        this.c = col;
        this.distance = distance;
    }

    public int getR() {
        return r;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "RCPair{" +
                "r=" + r +
                ", c=" + c +
                '}';
    }
}