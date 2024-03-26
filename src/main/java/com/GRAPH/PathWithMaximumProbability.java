package com.GRAPH;

import java.util.*;

class PathWithMaximumProbability {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};
        int start = 0, end = 2;
        System.out.println(maxProbability(n, edges, succProb, start, end));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> ((int) ((b[1] - a[1]) * 1000000000)));
        Map<Integer, Map<Integer, Double>> graphMap = buildGraph(edges, succProb);
        pq.offer(new double[]{start, 1.0});

        Set<Integer> vs = new HashSet<>();
        Map<Integer, Double> probs = new HashMap<>();

        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            if (vs.contains((int) curr[0])) continue;
            vs.add((int) curr[0]);
            if (((int) curr[0]) == end) return curr[1];
            for (int neighbour : graphMap.getOrDefault((int) curr[0], new HashMap<>()).keySet()) {
                if (vs.contains(neighbour)) continue;
                double prob = curr[1] * graphMap.get((int) curr[0]).get(neighbour);
                if (prob > probs.getOrDefault(neighbour, 0.0)) {
                    probs.put(neighbour, prob);
                    pq.offer(new double[]{neighbour, prob});
                }
            }
        }
        return 0;
    }

    private static Map<Integer, Map<Integer, Double>> buildGraph(int[][] edges, double[] succProb) {
        Map<Integer, Map<Integer, Double>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            graph.computeIfAbsent(edges[i][0], k -> new HashMap<>());
            graph.computeIfAbsent(edges[i][1], k -> new HashMap<>());
            graph.get(edges[i][0]).put(edges[i][1], succProb[i]);
            graph.get(edges[i][1]).put(edges[i][0], succProb[i]);
        }
        return graph;
    }
}