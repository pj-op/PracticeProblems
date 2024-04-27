package com.GRAPH;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
    public static void main(String[] args) {
        int[][] vertexMatrix = {
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 1}
        };

        int count = 0;
        int m = vertexMatrix.length;
        int n = vertexMatrix[0].length;
        boolean[][] visited = new boolean[m][n];

        /*for (int i = 0; i < vertexMatrix.length; i++) {
            for (int j = 0; j < vertexMatrix[0].length; j++) {
                if (vertexMatrix[i][j] == 1) {
                    printAdjacentNodePosition(i, j, vertexMatrix);
                }
            }
        }*/

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vertexMatrix[i][j] == 1 && !visited[i][j]) {
                    count++;
                    bfsUtil(i, j, vertexMatrix, visited);
                }
            }
        }

        System.out.println(count);
    }

    private static void printAdjacentNodePosition(int row, int col, int[][] vertexMatrix) {
        int m = vertexMatrix.length;
        int n = vertexMatrix[0].length;
        boolean[][] visited = new boolean[m][n];

        System.out.println("==========[" + row + "," + col + "]===============");
        for (int delRow = -1; delRow <= 1; delRow++) {
            for (int delCol = -1; delCol <= 1; delCol++) {
                int neighRow = delRow + row;
                int neighCol = delCol + col;
                if (neighRow >= 0 && neighCol >= 0 && !visited[neighRow][neighCol]
                        && neighRow < m && neighCol < n && vertexMatrix[neighRow][neighCol] == 1) {
                    System.out.println("ROW " + neighRow + " COL " + neighCol);
                    bfsUtil(row, col, vertexMatrix, visited);
                }
            }
        }
    }

    private static void bfsUtil(int row, int col, int[][] vertexMatrix, boolean[][] visited) {
        int m = vertexMatrix.length;
        int n = vertexMatrix[0].length;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int x = pair.firstNode;
            int y = pair.secondNode;

            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int neighRow = delRow + x;
                    int neighCol = delCol + y;
                    if (neighRow >= 0 && neighCol >= 0 && neighRow < m && neighCol < n && vertexMatrix[neighRow][neighCol] == 1 && !visited[neighRow][neighCol]) {
//                    System.out.println("ROW " + neighRow + " COL? " + neighCol);
                        visited[neighRow][neighCol] = true;
                        queue.add(new Pair(neighCol, neighCol));
                    }
                }
            }
        }
    }
}

class Pair {
    int firstNode;
    int secondNode;

    Pair(int firstNode, int secondNode) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
    }
}
