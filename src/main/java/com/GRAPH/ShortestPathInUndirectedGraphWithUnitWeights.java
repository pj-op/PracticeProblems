package com.GRAPH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInUndirectedGraphWithUnitWeights {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6}, {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}};
        int n = 9;
        int m = 10;
        int src = 0;


        calculateShortestDistance(edges, n, m, src);

    }

    private static void calculateShortestDistance(int[][] edges, int n, int m, int src) {

        List<Integer>[] adjList = new LinkedList[n];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
        for (int[] a : edges) {
            adjList[a[0]].add(a[1]);
            adjList[a[1]].add(a[0]);
        }
        System.out.println("AdjList: " + Arrays.toString(adjList));


        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        System.out.println(Arrays.toString(distance));

        Queue<Integer> queue = new LinkedList<>();
        distance[src] = 0;
        queue.add(src);


        while (!queue.isEmpty()) {
            int node = queue.poll();
//            System.out.print(node + " ");

            for (int neigh : adjList[node]) {
                if (distance[node] + 1 < distance[neigh]) {
                    distance[neigh] = distance[node] + 1;
                    queue.add(neigh);
                }
            }
        }
//        System.out.println();

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        System.out.println(Arrays.toString(distance));


        /*boolean[] visited = new boolean[n];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.println("inside if condition");
                printBfs(i, adjList, visited);
            }
        }*/


    }

    private static void printBfs(int node, List<Integer>[] adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int popNode = queue.poll();
            System.out.print(popNode + " ");

            for (int neigh : adjList[popNode]) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    queue.add(neigh);
                }
            }
        }


    }


}