package com.GRAPH;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycle {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addingEdge(0, 1);
        graph.addingEdge(1, 2);
        graph.addingEdge(2, 3);
        graph.addingEdge(3, 4);
        graph.addingEdge(4, 0);

        int count = 0;
        boolean[] visited = new boolean[graph.vertex];
        for (int i = 0; i < graph.vertex; i++) {
            if (!visited[i]) {
                if (bfsDetectCycle(i, graph.adjList, visited)) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
        }
    }

    private static boolean bfsDetectCycle(int node, List<Integer>[] adjList, boolean[] visited) {
        Queue<Pairs> queue = new LinkedList<>();
        queue.add(new Pairs(-1, node));
        visited[node] = true;

        while (!queue.isEmpty()) {
            Pairs p = queue.remove();
            int pNode = p.parentNode;
            int cNode = p.currNode;

            for (int a : adjList[cNode]) {
                if (!visited[a]) {
                    visited[a] = true;
                    queue.add(new Pairs(cNode, a));
                } else if (a != pNode) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Pairs {
    int parentNode;
    int currNode;

    Pairs(int parentNode, int currNode) {
        this.parentNode = parentNode;
        this.currNode = currNode;
    }
}

class Graph {
    int vertex;
    List<Integer>[] adjList;

    Graph(int vertex) {
        this.vertex = vertex;
        this.adjList = new List[vertex];
        for (int i = 0; i < vertex; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addingEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }
}