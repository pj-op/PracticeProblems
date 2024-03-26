package com.GRAPH.graphs;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.util.*;
import java.util.stream.IntStream;

public class ShortestPathVisitingAllNodes {
    public static void main(String[] args) {
        int[][] graph = {{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}}
                //{{1, 2, 3}, {0}, {0}, {0}}
                ;
//        System.out.println(shortestPathLengthDijkstra(graph));
//        System.out.println(shortestPathLength1(graph));
        System.out.println(shortestPathLength(graph));
    }

    private static int shortestPathLength(int[][] graph) {

        int n = graph.length;
        int resultMask = (1 << n) - 1;

        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            //{mask, i, }
            queue.add(new int[]{(1 << i), i, 0});
            visited.add((1 << i) * 16 + i);
        }

        while (!queue.isEmpty()) {
            int[] currNode = queue.poll();

            if (resultMask == currNode[0]) return currNode[2];

            for (int a : graph[currNode[1]]) {
                int newMask = currNode[0] | (1 << a);
                int checkHash = newMask * 16 + a;

                if (!visited.contains(checkHash)) {
                    visited.add(checkHash);
                    queue.add(new int[]{newMask, a, currNode[2] + 1});
                }
            }
        }
        return -1;
    }
}

class NodeWithDist {
    int dist;
    int node;

    public NodeWithDist(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}

class NodeDMask {
    int dist;
    int node;
    int mask;

    public NodeDMask(int node, int mask) {
        this.node = node;
        this.mask = mask;
    }

    public NodeDMask(int dist, int node, int mask) {
        this.dist = dist;
        this.node = node;
        this.mask = mask;
    }
}
