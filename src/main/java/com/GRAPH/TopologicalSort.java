package com.GRAPH;

// TOPOLOGICAL SORTING: In linear ordering of a DAG Directed Acyclic Graph u always comes before v i.e. u->v

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    public static void main(String[] args) {
        Gr graph = new Gr(6);
        graph.addDirectedEdge(2, 3);
        graph.addDirectedEdge(3, 1);
        graph.addDirectedEdge(4, 1);
        graph.addDirectedEdge(4, 0);
        graph.addDirectedEdge(5, 2);
        graph.addDirectedEdge(5, 0);

        boolean[] visited = new boolean[graph.vertex];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.vertex; i++) {
            if (!visited[i]) {
                dfsTopo(i, graph.adjList, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void dfsTopo(int node, List<Integer>[] adjList, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int a : adjList[node]) {
            if (!visited[a]) {
                dfsTopo(a, adjList, visited, stack);
            }
        }
        stack.push(node);
    }

}

class Gr {
    int vertex;
    List<Integer>[] adjList;

    Gr(int vertex) {
        this.vertex = vertex;
        this.adjList = new List[vertex];
        for (int i = 0; i < vertex; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addDirectedEdge(int source, int destination) {
        adjList[source].add(destination);
    }

}