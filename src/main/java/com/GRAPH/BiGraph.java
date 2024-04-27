package com.GRAPH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BiGraph {
    public static void main(String[] args) {
        Graphings graph = new Graphings(8);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(2, 4);

        System.out.println(Arrays.deepToString(graph.adjList));
        int[] colorMatrix = new int[graph.vertex];
        Arrays.fill(colorMatrix, -1);

        for (int i = 0; i < graph.vertex; i++) {
            if (colorMatrix[i] == -1) {
                if (bfsRouting(i, colorMatrix, graph.adjList)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
        System.out.println(Arrays.toString(colorMatrix));

        /*Arrays.fill(colorMatrix, -1);
        for (int i = 0; i < graph.vertex; i++) {
            if (colorMatrix[i] == -1) {
                if (dfsRouting(i, colorMatrix, graph.adjList, 0)) {
                    System.out.println("Yes");
                }
            } else {
                System.out.println("No");
            }
        }
        System.out.println(Arrays.toString(colorMatrix));*/
    }

    private static boolean dfsRouting(int node, int[] colorMatrix, List<Integer>[] adjList, int color) {
        colorMatrix[node] = color;
        for (int a : adjList[node]) {
            if (colorMatrix[a] == -1) {
                dfsRouting(a, colorMatrix, adjList, 1 - colorMatrix[node]);
            } else if (colorMatrix[a] == colorMatrix[node]) {
                return false;
            }
        }
        return true;
    }

    private static boolean bfsRouting(int node, int[] colorMatrix, List<Integer>[] adjList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        colorMatrix[node] = 0;

        while (!queue.isEmpty()) {
            int x = queue.peek();
            queue.remove();
            for (int a : adjList[x]) {
                if (colorMatrix[a] == -1) {
                    colorMatrix[a] = 1 - colorMatrix[x];
                    queue.add(a);
                } else if (colorMatrix[a] == colorMatrix[x]) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Graphings {
    public int vertex;
    public List<Integer>[] adjList;

    public Graphings(int vertex) {
        this.vertex = vertex;
        this.adjList = new List[vertex];
        for (int i = 0; i < vertex; i++) {
            adjList[i] = new LinkedList();
        }
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }
}
