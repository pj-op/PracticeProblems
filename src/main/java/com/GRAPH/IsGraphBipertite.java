package com.GRAPH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipertite {
    public static void main(String[] args) {
        int[][] graph =
//                {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
                {{1,3},{0,2},{1,3},{0,2}};
//                {{1, 2, 3}, {0, 3, 4}, {0, 3}, {0, 1, 2}, {1}};
        System.out.println(isBipartite(graph));
    }

    public static boolean isBipartite(int[][] graph) {

        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for (int i = 0; i < color.length; i++) {
            if (color[i] == -1) {
                if (!performBiGraphBFS(i, color, graph)) {
                    return false;
                }
            }
        }
        System.out.println(Arrays.toString(color));
        return true;
    }

    private static boolean performBiGraphBFS(int i, int[] color, int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        color[i] = 0;

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            int currColor = color[currNode];

            for (int neigh : graph[currNode]) {
                if (color[neigh] == -1) {
                    color[neigh] = currColor == 0 ? 1 : 0;
                    queue.add(neigh);
                } else if (currColor == color[neigh]) {
                    return false;
                }
            }
        }
        return true;
    }
}
