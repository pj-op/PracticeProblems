package com.GRAPH;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Djkstra {
    public static void main(String[] args) {
        int V = 3, E = 3;
        int[][][] adj = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}};
        int S = 2;

        findShortestPathUsingDijkstra(V, S, adj);
//        prepareList(adj);
        findShortestPathUsingDijkstraRecap(V, S, adj);
    }

    private static void findShortestPathUsingDijkstraRecap(int numberOfVertex, int source, int[][][] adj) {
        List<List<List<Integer>>> adjList = new ArrayList<>();
        Queue<PairIt> queue = new PriorityQueue(Comparator.comparingInt(PairIt::getWeight));

        for (int i = 0; i < adj.length; i++) {
            adjList.add(new ArrayList<>());
            for (int j = 0; j < adj[i].length; j++) {
                adjList.get(i).add(new ArrayList<>());
                for (int k = 0; k < adj[i][j].length; k++) {
                    adjList.get(i).get(j).add(adj[i][j][k]);
                }
            }
        }
//        System.out.println(adjList);

        int[] distance = new int[numberOfVertex];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        queue.add(new PairIt(source, 0));

        while (!queue.isEmpty()) {
            PairIt pairIt = queue.poll();
            int currNode = pairIt.getNode();
            int currentWeight = pairIt.getWeight();

            for (List<Integer> neigh : adjList.get(currNode)) {
                int neighbourNode = neigh.get(0);
                int neighbourWeight = neigh.get(1);

                if (currentWeight + neighbourWeight < distance[neighbourNode]) {
                    distance[neighbourNode] = currentWeight + neighbourWeight;
                    queue.add(new PairIt(neighbourNode, distance[neighbourNode]));
                }

            }

        }
        System.out.println(Arrays.toString(distance));

    }

    /*
    private static void prepareList(int[][][] adj) {
        Integer[][] a = {{1, 2, 3}, {6, 8}};
        List<List<Integer>> result = new ArrayList<>();
        List<List<List<Integer>>> ans = new ArrayList<>();

        Arrays.stream(a).forEach(x ->
                //System.out.println(Arrays.deepToString(x))
                result.add(new ArrayList<>(List.of(x)))
        );

        Arrays.stream(adj).forEach(x ->
//                System.out.println(Arrays.deepToString(x));
                ans.addAll((Collection<? extends List<List<Integer>>>) List.of(x).stream().map(y ->
                        new ArrayList<>(List.of(y))).collect(Collectors.toList())
                ));

    }
*/
    private static void findShortestPathUsingDijkstra(int numOfVertex, int source, int[][][] adjArray) {
        List<List<List<Integer>>> adjList = new LinkedList<>();
        Queue<PairIt> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));

        for (int i = 0; i < adjArray.length; i++) {
            adjList.add(new LinkedList<>());
            for (int j = 0; j < adjArray[i].length; j++) {
                adjList.get(i).add(new LinkedList<>());
                for (int k = 0; k < adjArray[i][j].length; k++) {
                    adjList.get(i).get(j).add(adjArray[i][j][k]);
                }
            }
        }

        int[] distance = new int[numOfVertex];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        queue.add(new PairIt(source, 0));

        while (!queue.isEmpty()) {
            PairIt pairIt = queue.poll();
            int currNode = pairIt.getNode();
            int dist = pairIt.getWeight();

            for (int i = 0; i < adjList.get(currNode).size(); i++) {
                int newNode = adjList.get(currNode).get(i).get(0);
                int newDist = adjList.get(currNode).get(i).get(1);
                if (dist + newDist < distance[newNode]) {
                    distance[newNode] = dist + newDist;
                    queue.add(new PairIt(newNode, distance[newNode]));
                }
            }
        }


        System.out.println(Arrays.toString(distance));
//        System.out.println(queue);
    }
}

@Data
@AllArgsConstructor
class PairIt {
    int node;
    int weight;

    public int getNode() {
        return node;
    }

    public PairIt setNode(int node) {
        this.node = node;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public PairIt setWeight(int weight) {
        this.weight = weight;
        return this;
    }
}