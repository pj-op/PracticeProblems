package com.practice;

import java.util.LinkedList;

public class GraphTheory {

    public static void main(String[] args) {
        Grp grp = new Grp(8);

        grp.addEdge(0, 1);
        grp.addEdge(0, 7);
        grp.addEdge(3, 6);
        grp.addEdge(5, 5);
        grp.addEdge(7, 2);
        grp.addEdge(4, 5);
        grp.addEdge(5, 4);

        grp.printGrp();
    }

}

class Grp {
    private int vertex;
    private LinkedList[] adjList;

    Grp(int vertex) {
        this.vertex = vertex;
        this.adjList = new LinkedList[vertex];
        for (int i = 0; i < vertex; i++) {
            adjList[i] = new LinkedList();
        }
    }

    public void addEdge(int source, int destination) {
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

    public void printGrp() {
        for (int i = 0; i < adjList.length; i++) {
            System.out.print("vertex for node " + i + " : ");
            for (int j = 0; j < adjList[i].toArray().length; j++) {
                System.out.print(" " + adjList[i].get(j) + " ");
            }
            System.out.println();
        }
    }
}
