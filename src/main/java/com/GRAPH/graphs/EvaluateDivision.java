package com.GRAPH.graphs;

import java.util.*;

//https://leetcode.com/problems/evaluate-division/
/*
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation:
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 */


public class EvaluateDivision {
    public static void main(String[] args) {
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"));

        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node11>> numMap = buildGraph(equations, values);

        double[] resultArray = new double[queries.size()];

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = dfsForQueries(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), numMap);
        }

        return resultArray;
    }

    private static double dfsForQueries(String src, String dest, HashSet<String> visited, Map<String, List<Node11>> numMap) {
        if (!(numMap.containsKey(src) && numMap.containsKey(dest))) return -1.0;
        if (src.equals(dest)) return 1.0;

        visited.add(src);
        for (Node11 neigh : numMap.get(src)) {
            if (!visited.contains(neigh.getVertex())) {
                double ans = dfsForQueries(neigh.getVertex(), dest, visited, numMap);
                if (ans != -1) return ans * neigh.val;
            }
        }
        return -1;
    }

    private static Map<String, List<Node11>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Node11>> graph = new HashMap<>();

        for (int i = 0; i < values.length; i++) {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);

            graph.putIfAbsent(src, new ArrayList<>());
            graph.putIfAbsent(dest, new ArrayList<>());

            graph.get(src).add(new Node11(dest, values[i]));
            graph.get(dest).add(new Node11(src, 1 / values[i]));

        }

        return graph;
    }
}

class Node11 {
    String vertex;
    double val;

    Node11(String vertex, double val) {
        this.vertex = vertex;
        this.val = val;
    }

    public String getVertex() {
        return vertex;
    }

    public double getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "vertex='" + vertex + '\'' +
                ", val=" + val +
                '}';
    }
}
