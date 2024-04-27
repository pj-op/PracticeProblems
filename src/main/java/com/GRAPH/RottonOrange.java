package com.GRAPH;

//Rotten the oranges in vertical and horizontal way

import java.util.LinkedList;
import java.util.Queue;

public class RottonOrange {
    public static void main(String[] args) {
        int[][] fruitBox = {
                //Test Case: 1
                {0, 1, 2},
                {0, 1, 1},
                {2, 1, 1},
        };

        int m = fruitBox.length;
        int n = fruitBox[0].length;
        int[][] visited = new int[m][n];

        int delRowArr[] = {-1, 0, 1, 0};
        int delColArr[] = {0, 1, 0, -1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (fruitBox[i][j] == 2 && visited[i][j] != 2) {
                    bfsOrange(i, j, fruitBox, visited, delRowArr, delColArr);
                }
            }
        }
    }

    private static void bfsOrange(int row, int col, int[][] fruitBox, int[][] visited, int[] delRowArr, int[] delColArr) {
        int m = fruitBox.length;
        int n = fruitBox[0].length;

        int timeUnit = 0;

        Queue<Neighbour> queue = new LinkedList<>();
        queue.add(new Neighbour(row, col, timeUnit));
        visited[row][col] = 2;

        while (!queue.isEmpty()) {
            Neighbour neighbour = queue.poll();
            int r = neighbour.firstNode;
            int c = neighbour.secondNode;

            for (int i = 0; i < 4; i++) {
                int nRow = r + delRowArr[i];
                int nCol = c + delColArr[i];


                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && fruitBox[nRow][nCol] == 1 && visited[nRow][nCol] != 2) {
                    visited[nRow][nCol] = 2;
                    queue.add(new Neighbour(nRow, nCol, timeUnit++));
                }
            }
        }

        System.out.println("TImeUnit: " + timeUnit);
    }
}

class Neighbour {
    int firstNode;
    int secondNode;
    int timeUnit;

    Neighbour(int firstNode, int secondNode, int timeUnit) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.timeUnit = timeUnit;
    }
}
