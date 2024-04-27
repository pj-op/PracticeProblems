package com.GRAPH;

import java.util.*;

public class TopologicalKahn {
    public static void main(String[] args) {
        Gr graph = new Gr(6);
        graph.addDirectedEdge(3, 1);
        graph.addDirectedEdge(2, 3);
        graph.addDirectedEdge(4, 1);
        graph.addDirectedEdge(4, 0);
        graph.addDirectedEdge(5, 0);
        graph.addDirectedEdge(5, 2);

        int[] indegree = new int[graph.vertex];

        for (int i = 0; i < graph.adjList.length; i++) {
            for (int a : graph.adjList[i]) {
                indegree[a]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topoList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoList.add(node);
            for (int a : graph.adjList[node]) {
                indegree[a]--;
                if (indegree[a] == 0) {
                    queue.add(a);
                }
            }
        }

        System.out.println(topoList);
        System.out.println("Indegree :"+Arrays.toString(indegree));
    }
}
