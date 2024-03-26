package com.GRAPH.ass;

import java.util.*;

public class CreatAdjList {
    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        minReorder(n, connections);
    }

    public static int minReorder(int n, int[][] connections) {
        List<Integer>[] adjlist = new List[n];

        for (int i = 0; i < adjlist.length; i++) {
            adjlist[i] = new ArrayList<>();
        }

        for (int[] a : connections) {
            adjlist[a[0]].add(a[1]);
        }

        System.out.println(Arrays.toString(adjlist));

        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(0);

        while (!queue.isEmpty()){
            int node = queue.poll();

            for (int neigh : adjlist[node]){

            }



        }



        return 0;
    }
}
