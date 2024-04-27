package com.GRAPH.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Graph {
    int numOfVertices;
    List<Integer>[] adjacencyList;

    Graph(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        adjacencyList = new LinkedList[numOfVertices];
        for (int i = 0; i < numOfVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source);
    }

    void printGraph() {
        for (int i = 0; i < numOfVertices; i++) {
            System.out.print("Adjacency list of vertex " + i + ": ");
            for (Integer vertex : adjacencyList[i]) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }

    void printAdjecencyArray(){
        System.out.println(Arrays.toString(adjacencyList));
    }
}

public class GraphDemo {
    public static void main(String[] args) {
        int numOfVertices = 5;
        Graph graph = new Graph(numOfVertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printGraph();
        graph.printAdjecencyArray();
    }
}
