package com.GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class GraphTest {
    private int numberOfVertex;
    private List<Integer>[] adjList;

    GraphTest(int numberOfVertex) {
        this.numberOfVertex = numberOfVertex;
        this.adjList = new List[numberOfVertex];
        for (int i = 0; i < numberOfVertex; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void dfs(int startNode) {
        boolean[] visited = new boolean[numberOfVertex];
        dfsUtlis(startNode, visited);
    }

    public void bfs(int startNode) {
        boolean[] visited = new boolean[numberOfVertex];
        bfsUtlis(startNode, visited);
    }

    private void bfsUtlis(int node, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");
            for (int a : adjList[x]) {
                if (!visited[a]) {
                    visited[a] = true;
                    queue.add(a);
                }
            }
        }
    }

    private void dfsUtlis(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int x : adjList[node]) {
            if (!visited[x]) {
                dfsUtlis(x, visited);
            }
        }
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    public void printGraph() {
        for (int i = 0; i < numberOfVertex; i++) {
            System.out.print("Vertex: " + i + ": ");
            for (int x : adjList[i]) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}


public class GraphsDemos {
    public static void main(String[] args) {
        GraphTest grap = new GraphTest(10);

        grap.addEdge(0, 1);
        grap.addEdge(0, 2);
        grap.addEdge(2, 4);
        grap.addEdge(1, 3);
        grap.addEdge(5, 2);
        grap.addEdge(6, 8);
        grap.addEdge(7, 6);
        grap.addEdge(6, 9);
        grap.addEdge(3, 6);

//        grap.printGraph();
        System.out.print("DFS: ");
        grap.dfs(3);
        System.out.println();
        System.out.print("BFS: ");
        grap.bfs(3);
    }
}