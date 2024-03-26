package com.GRAPH.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/

/*      Type 1: Can be traversed by Alice only.
        Type 2: Can be traversed by Bob only.
        Type 3: Can be traversed by both Alice and Bob.
*/

public class EdgesToRemove {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges =
//                {{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}}
//                {{3,1,2},{3,2,3},{1,1,4},{2,1,4}}
        {{3,2,3},{1,1,2},{2,3,4}}
                ;
        Graph_02 graph02 = new Graph_02(n + 1);

        for (int[] edge : edges) {
            graph02.addEdgeBasedOnType(edge[0], edge[1], edge[2]);
        }

        System.out.println(Arrays.toString(graph02.adjList));

    }
}

class Graph_02 {
    int numOfVertices;
    List<Integer>[] adjList;

    Graph_02(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        this.adjList = new List[numOfVertices];
        for (int i = 0; i < numOfVertices; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdgeBasedOnType(int type, int src, int des) {
        if (type == 1) {
            adjList[src].add(des);
        } else if (type == 2) {
            adjList[des].add(src);
        } else {
            adjList[src].add(des);
            adjList[des].add(src);
        }
    }
}