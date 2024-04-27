package com.GRAPH;

//https://leetcode.com/problems/is-graph-bipartite/ ACCEPTED

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipirateOrBiGraph {
    public static void main(String[] args) {
        int[][] graphAdjList = {
                //TEST CASE: 1
                /*{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}*/
                //TEST CASE: 2
                /*{1, 6}, {0, 2}, {1, 3}, {2, 7, 4}, {3, 5}, {4}, {0, 7}, {3, 6}*/
                //TEST CASE: 3
                {1, 2, 3}, {0, 3, 4}, {0, 3}, {0, 1, 2}, {1}
        };
        int numOfVertex = graphAdjList.length;
        int[] colorMatrix = new int[numOfVertex];
        Arrays.fill(colorMatrix, -1);

        for (int i = 0; i < numOfVertex; i++) {
            if (colorMatrix[i] == -1) {
                if (!bfsBiGraph(i, graphAdjList, colorMatrix)) {
//                    return false;
                    System.out.println("false");
                }
            }
        }
//        return true;
        System.out.println("true");

        Arrays.fill(colorMatrix, -1);
        // for (int i = 0; i < numOfVertex; i++) {
        //     if (colorMatrix[i] == -1) {
        //         if (!dfsGraph(i, graphAdjList, colorMatrix, 1)) {
        //             return false;
        //         }
        //     }
        // }
        // return true;

        System.out.println(Arrays.toString(colorMatrix));
    }

    private static boolean dfsGraph(int node, int[][] graphAdjList, int[] colorMatrix, int color) {
        colorMatrix[node] = color;

        for (int a : graphAdjList[node]) {
            if (colorMatrix[a] == -1) {
                dfsGraph(a, graphAdjList, colorMatrix, (colorMatrix[node] - 1) == 0 ? 0 : 1);
            } else if (colorMatrix[a] == colorMatrix[node]) {
                return false;
            }
        }
        return true;
    }

    private static boolean bfsBiGraph(int node, int[][] graphAdjList, int[] colorMatrix) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        colorMatrix[node] = 0;

        while (!queue.isEmpty()) {
            int a = queue.peek();
            queue.remove();
            for (int x : graphAdjList[a]) {
                if (colorMatrix[x] == -1) {
                    colorMatrix[x] = 1 - colorMatrix[a];
                    queue.add(x);
                } else if (colorMatrix[x] == colorMatrix[a]) {
                    return false;
                }
            }
        }
        return true;
    }

}