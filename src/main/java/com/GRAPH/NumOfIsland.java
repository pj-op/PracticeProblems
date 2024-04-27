package com.GRAPH;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

public class NumOfIsland {
    public static void main(String[] args) {
        int vertexMatrix[][] = {
                //Test Case: 1
                /*{0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 1}*/
                //Test Case: 2
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 1}


        };
        int numberOfIsland = 0;
        int m = vertexMatrix.length;
        int n = vertexMatrix[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && vertexMatrix[i][j] == 1) {
                    bfsHere(i, j, vertexMatrix, visited);
                    numberOfIsland++;
                }
            }
        }
        System.out.println(numberOfIsland);
    }

    private static void bfsHere(int row, int col, int[][] vertexMatrix, boolean[][] visited) {
        int m = vertexMatrix.length;
        int n = vertexMatrix[0].length;

        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(row, col);
        queue.add(node);

        while (!queue.isEmpty()) {
            Node x = queue.poll();
            visited[row][col] = true;
            int y = x.getFirstNode();
            int z = x.getSecondNode();

            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int nrow = y + delRow;
                    int nclo = z + delCol;
                    if (nrow >= 0 && nrow < m && nclo >= 0 && nclo < n && vertexMatrix[nrow][nclo] == 1 && !visited[nrow][nclo]) {
                        visited[nrow][nclo] = true;
                        queue.add(new Node(nrow, nclo));
                    }
                }
            }
        }
    }
}

@Data
class Node {
    private int firstNode;
    private int secondNode;

    Node(int firstNode, int secondNode) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
    }
}