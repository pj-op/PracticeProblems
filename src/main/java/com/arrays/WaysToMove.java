package com.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WaysToMove {
    public static void main(String[] args) {
        int[][] testCase = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        int result = 0;
        int n = testCase.length;
        int m = testCase[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && testCase[i][j] != 1) {
                    bfsUtilWays(i, j, visited, testCase, result);
                }
            }
        }
        System.out.println("Result: " + result);
        System.out.println(Arrays.deepToString(visited));
    }

    private static void bfsUtilWays(int fNode, int sNode, boolean[][] visited, int[][] testData, int result) {
        int n = testData.length;
        int m = testData[0].length;

        Queue<Node1> queue = new LinkedList<>();
        queue.add(new Node1(fNode, sNode));
        visited[fNode][sNode] = true;

        int[] delRowArr = {0, 1};
        int[] delColArr = {1, 0};

        while (!queue.isEmpty()) {
            Node1 node1 = queue.poll();

            for (int i = 0; i < delColArr.length; i++) {
                int nRow = node1.first + delRowArr[i];
                int nCol = node1.second + delColArr[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !visited[nRow][nCol] && testData[nRow][nCol] == 0) {
                    visited[nRow][nCol] = true;
                    testData[nRow][nCol] = 1;
                    if (nRow == m - 1 && nCol == n - 1) {
                        result++;
                    }
                    queue.add(new Node1(nRow, nCol));
                }
            }

        }
        System.out.println(result);

    }
}

class Node1 {
    int first;
    int second;

    Node1(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
