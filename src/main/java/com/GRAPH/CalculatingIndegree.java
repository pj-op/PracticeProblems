package com.GRAPH;

import java.util.*;

public class CalculatingIndegree {
    public static void main(String[] args) {

        List<List<Integer>> adj = Arrays.asList(List.of(), List.of(3), List.of(3), List.of(),
                List.of(0, 1), List.of(2, 0));

        System.out.println(Arrays.toString(topoSort(adj.size(), adj)));

    }

    static int[] topoSort(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];
        int[] topoSort = new int[V];

        for (List<Integer> a : adj) {
            for (Integer i : a) {
                inDegree[i]++;
            }
        }
        System.out.println(Arrays.toString(inDegree));


        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        System.out.println(queue);
        int i = 0;

        while (!queue.isEmpty()) {
            int currElement = queue.poll();
            topoSort[i++] = currElement;
            for (int a : adj.get(currElement)) {
                inDegree[a]--;
                if (inDegree[a] == 0) {
                    queue.add(a);
                }
            }
        }
        return topoSort;
    }
}
