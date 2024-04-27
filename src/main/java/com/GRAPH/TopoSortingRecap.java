package com.GRAPH;

// Applies only on DAC directed Acyclic Graph

import java.util.*;
import java.util.stream.Collectors;

class Draft {
    int numberOfVertex;
    List<Integer>[] adjList;

    Draft(int numberOfVertex) {
        this.numberOfVertex = numberOfVertex;
        this.adjList = new List[numberOfVertex];
        for (int i = 0; i < numberOfVertex; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addDirectedEdge(int source, int destination) {
        adjList[source].add(destination);
    }
}

public class TopoSortingRecap {
    public static void main(String[] args) {
        Draft graph = new Draft(5);
        graph.addDirectedEdge(0, 1);
        graph.addDirectedEdge(1, 2);
        graph.addDirectedEdge(4, 2);
        graph.addDirectedEdge(2, 3);
        graph.addDirectedEdge(0, 4);

//        System.out.println(Arrays.toString(graph.adjList));

        topoSortingUsingBfs(graph);
        topoSortingUsingDfs(graph);

    }

    private static void topoSortingUsingDfs(Draft graph) {

        boolean[] visited = new boolean[graph.numberOfVertex];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfsUtil(i, graph.adjList, visited, stack);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
//            System.out.println("index: " + i + "and popping element: " + result[i]);
        }
        System.out.println(Arrays.toString(result));
    }

    private static void dfsUtil(int node, List<Integer>[] adjList, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int neigh : adjList[node]) {
            if (!visited[neigh]) {
                dfsUtil(neigh, adjList, visited, stack);
            }
        }
        stack.add(node);
    }

    private static void topoSortingUsingBfs(Draft graph) {

        //Need to calculate the inDegree
        int[] inDegree = new int[graph.numberOfVertex];

        for (int i = 0; i < inDegree.length; i++) {
            for (int a : graph.adjList[i]) {
                inDegree[a]++;
            }
        }

        //System.out.println("InDegree: " + Arrays.toString(inDegree));

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topoSort = new LinkedList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoSort.add(node);
            for (int neigh : graph.adjList[node]) {
                inDegree[neigh]--;
                if (inDegree[neigh] == 0) queue.add(neigh);
            }
        }

        System.out.println(topoSort);

    }
}
