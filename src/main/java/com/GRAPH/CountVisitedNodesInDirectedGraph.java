package com.GRAPH;

import java.util.*;

public class CountVisitedNodesInDirectedGraph {
    public static void main(String[] args) {
        List<Integer> edges = List.of(
                1, 2, 0, 0
//                1, 2, 3, 4, 0
        );
        System.out.println(Arrays.toString(countVisitedNodesUsingTopoSort(edges)));
    }

    private static int[] countVisitedNodesUsingTopoSort(List<Integer> edges) {

        int[] result = new int[edges.size()];
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[edges.size()];
        Queue<Integer> queue = new PriorityQueue<>();

        //Calculate the in-degree
        int[] indegree = new int[edges.size()];

        for (int edge : edges) {
            indegree[edge]++;
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            stack.push(curNode);
            visited[curNode] = true;

            int neigh = edges.get(curNode);
            indegree[neigh]--;
            if (indegree[neigh] == 0) {
                queue.add(neigh);
            }
        }

        //Visiting the non visited nodes
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                fillCycle(i, edges, visited, result);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            result[top] = result[edges.get(top)] + 1;
        }

//        System.out.println("Result: " + Arrays.toString(result));
//        System.out.println("Stack: " + stack);

        return result;
    }

    private static void fillCycle(int src, List<Integer> edges, boolean[] visited, int[] result) {
        int count = 0;
        for (int i = src; !visited[i]; i = edges.get(i)) {
            visited[i] = true;
            count++;
        }
        result[src] = count;
        for (int i = edges.get(src); i != src; i = edges.get(i)) {
            result[i] = count;
        }
    }

    public static int[] countVisitedNodes(List<Integer> edges) {
        int[] result = new int[edges.size()];
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < edges.size(); i++) {
            if (!visited.contains(i)) {
                result[i] = performBFSFromEveryNode(i, edges, visited);
            }
            visited.clear();
        }
        return result;
    }

    private static int performBFSFromEveryNode(int src, List<Integer> adjList, Set<Integer> visited) {
        int count = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(src);
        count++;
        visited.add(src);
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            int neigh = adjList.get(currNode);
            if (!visited.contains(neigh)) {
                visited.add(neigh);
                queue.add(neigh);
                count++;
            }
        }
        return count;
    }
}
