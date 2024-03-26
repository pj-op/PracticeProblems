package com.GRAPH.graphpractice;

import lombok.Data;

import java.util.*;
import java.util.stream.IntStream;

public class GraphRecap {
    public static void main(String[] args) {
        Grp grp = new Grp(6);

        grp.addEdge(0, 1);
        grp.addEdge(0, 2);
        grp.addEdge(1, 2);
        grp.addEdge(2, 3);
        grp.addEdge(2, 4);
        grp.addEdge(2, 5);
        grp.addEdge(5, 3);
        grp.addEdge(5, 4);

//        grp.printAdjList();

        // Dijkstra

        int[][][] adjList = {
                //Test Case - 1
                {{1, 1}, {2, 6}},   //0
                {{2, 3}, {0, 1}},   //1
                {{1, 3}, {0, 6}}    //2
                //Test Case - 2
                /*{{1, 9}}, {{0, 9}}*/

        };

        findSortestPathUsingDijkstra(adjList.length, adjList);

    }

    private static void findSortestPathUsingDijkstra(int vertex, int[][][] adjList) {

        int SOURCE = 2;

        // Min heap
        Queue<P> pq = new PriorityQueue<>(Comparator.comparingInt(P::getDistance));

        int[] distance = new int[vertex];
        IntStream.range(0, distance.length).forEach(i -> distance[i] = Integer.MAX_VALUE);

        distance[SOURCE] = 0;

        P pair = new P(SOURCE, 0);
        pq.add(pair);

        while (!pq.isEmpty()) {
            P pollingPair = pq.poll();
            int node = pollingPair.getNode();
            int dist = pollingPair.getDistance();

            for (int[] neigh : adjList[node]) {
                int neighNode = neigh[0];
                int neighWeight = neigh[1];

                if (dist + neighWeight < distance[neighNode]) {
                    distance[neighNode] = dist + neighWeight;
                    pq.add(new P(neighNode, distance[neighNode]));
                }
            }
        }

        System.out.println(Arrays.toString(distance));
    }
}

class Grp {
    private int v;
    private List<Integer>[] adjList;

    Grp(int v) {
        this.v = v;
        this.adjList = new List[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    //Bi-Directional
    void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    void printAdjList() {
        for (List<Integer> list : adjList) {
            System.out.println(list);
        }
    }
}

@Data
class P {
    private int node;
    private int distance;

    P(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}