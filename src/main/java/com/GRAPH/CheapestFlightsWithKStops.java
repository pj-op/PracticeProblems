package com.GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class CheapestFlightsWithKStops {
    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, k = 1;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

    private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //Preparing adjlist
        List<List<PairDeCo>> adjList = new ArrayList<>();
        IntStream.range(0, n).forEach(indx -> adjList.add(new ArrayList<>()));

        //Unidirectional Edges
        for (int[] flight : flights) {
            adjList.get(flight[0]).add(new PairDeCo(flight[1], flight[2]));
        }

        //Distance Array with max value
        int[] distArr = new int[n];
        IntStream.range(0, n).forEach(i -> distArr[i] = Integer.MAX_VALUE);

        Queue<Flights> queue = new LinkedList<>();
        Flights flights1 = new Flights(0, src, 0);
        queue.add(flights1);
        distArr[src] = 0;

        while (!queue.isEmpty()) {
            Flights curr = queue.poll();
            int stop = curr.stop;
            int node = curr.node;
            int dist = curr.dist;

            if (stop > k) continue;
            for (PairDeCo neigh : adjList.get(node)) {
                int adjNode = neigh.destination;
                int edgeWeight = neigh.cost;

                int totalDist = dist + edgeWeight;
                if (totalDist < distArr[adjNode]) {
                    distArr[adjNode] = totalDist;
                    queue.add(new Flights(stop + 1, adjNode, totalDist));
                }
            }
        }
        return distArr[dst] == Integer.MAX_VALUE ? -1 : distArr[dst];
    }
}

class PairDeCo {
    int destination;
    int cost;

    PairDeCo(int destination, int cost) {
        this.cost = cost;
        this.destination = destination;
    }
}

class Flights {
    int stop;
    int node;
    int dist;

    Flights(int stop, int node, int dist) {
        this.stop = stop;
        this.node = node;
        this.dist = dist;
    }
}