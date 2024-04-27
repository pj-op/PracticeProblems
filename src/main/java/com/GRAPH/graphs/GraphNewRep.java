package com.GRAPH.graphs;

import java.util.LinkedList;
import java.util.List;

public class GraphNewRep {
    public static void main(String[] args) {
        GraphIt graphIt = new GraphIt(6);
        graphIt.addingEdge(0,1);
        graphIt.addingEdge(3,5);
        graphIt.addingEdge(4,2);
        graphIt.addingEdge(0,3);
        graphIt.addingEdge(1,4);
        graphIt.addingEdge(3,2);
        graphIt.addingEdge(2,5);
        graphIt.addingEdge(5,2);


        graphIt.printGraphIt();


    }
}

class GraphIt {
    private final int numberOfVertex;
    List<Integer>[] adjList;

    GraphIt(int numberOfVertex) {
        this.numberOfVertex = numberOfVertex;
        adjList = new LinkedList[numberOfVertex];
        for (int i = 0; i < numberOfVertex; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addingEdge(int source, int destination) {
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

    void printGraphIt() {
        for (int i = 0; i < numberOfVertex; i++) {
            System.out.print("vertex for " + i + " : ");
            for (Integer vertex : adjList[i]) {
                System.out.print(vertex +" ");
            }
            System.out.println();
        }
    }
}