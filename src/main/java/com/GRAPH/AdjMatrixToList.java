package com.GRAPH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjMatrixToList {
    public static void main(String[] args) {
        int [][] adjMatrix = new int[][]{
                //Test Case : -1
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
                //TEST CASE:0
                /*{1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}*/
                //TEST CASE:1
                /*{0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0},
                {1, 0, 0, 0}*/
                //TEST CASE:2
                /*{0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0}*/
        };
        int numVertex = adjMatrix.length;
        int start_node = 0;
        boolean visited[] = new boolean[numVertex];
        int count = 0;
//        System.out.println(Arrays.toString(getAdjListFromAdjMatrix(adjMatrix, numVertex)));
        /*System.out.print("DFS: ");
        dfs(start_node, getAdjListFromAdjMatrix(adjMatrix, numVertex), new boolean[numVertex]);
        System.out.println();
        System.out.print("BFS: ");
        bfs(start_node, getAdjListFromAdjMatrix(adjMatrix, numVertex), new boolean[numVertex]);*/

        for (int i = 0; i < numVertex; i++) {
            if (!visited[i]) {
                dfs(i, getAdjListFromAdjMatrix(adjMatrix, numVertex), visited);
                count++;
            }
        }
        System.out.println();
        System.out.println("Number of province : " + count);

    }

    private static void bfs(int node, List<Integer>[] adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");
            for (int a : adjList[x]) {
                if (!visited[a]) {
                    queue.add(a);
                    visited[a] = true;
                }
            }
        }
    }

    private static void dfs(int node, List<Integer>[] adjList, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int a : adjList[node]) {
            if (!visited[a]) {
                dfs(a, adjList, visited);
            }
        }
    }

    public static List<Integer>[] getAdjListFromAdjMatrix(int[][] adjMatrix, int V) {
        List<Integer>[] adjList = new List[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adjMatrix[i][j] == 1 && i != j) {
                    adjList[i].add(j);
                }
            }
        }
        return adjList;
    }

}
