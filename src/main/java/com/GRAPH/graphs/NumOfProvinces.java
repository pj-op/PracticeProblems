package com.GRAPH.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class NumOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int count = 0;
        List<Integer>[] adjList = prepareAdjListNow(isConnected);
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                performingDFS(i, visited, adjList);
                count++;
            }
        }
        return count;
    }

    private static void performingDFS(int node, boolean[] visited, List<Integer>[] adjList) {
        visited[node] = true;
        for (int neigh : adjList[node]) {
            if (!visited[neigh]) {
                performingDFS(neigh, visited, adjList);
            }
        }
    }

    private static List<Integer>[] prepareAdjListNow(int[][] isConnected) {
        List<Integer>[] adjList = new List[isConnected.length];
        IntStream.range(0, adjList.length).forEach(i -> adjList[i] = new LinkedList<>());

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (i != j && isConnected[i][j] == 1) adjList[i].add(j);
            }
        }
        return adjList;
    }
}
