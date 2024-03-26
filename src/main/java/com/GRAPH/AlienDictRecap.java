package com.GRAPH;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictRecap {
    public static void main(String[] args) {
        String[] testCase = {"baa", "abcd", "abca", "cab", "cad", "cade"};

        String ans = "";
        for (int a : findPairingComparison(testCase)) {
            ans = ans + (char) (a + 'a');
        }
        System.out.println(ans);
    }

    private static List<Integer> findPairingComparison(String[] testCase) {

        Gr graph = new Gr(5);

        for (int i = 0; i < testCase.length - 1; i++) {
            String first = testCase[i];
            String second = testCase[i + 1];

            for (int j = 0; j < Math.min(first.length(), second.length()); j++) {
                char firstChar = first.charAt(j);
                char secondChar = second.charAt(j);

                if (firstChar != secondChar) {
                    graph.addDirectedEdge(firstChar - 'a', secondChar - 'a');
                    break;
                }
            }
        }
//        System.out.println(Arrays.toString(graph.adjList));
        //Calculate the indegree
        int[] indegArr = new int[graph.vertex];

        for (int j = 0; j < indegArr.length; j++) {
            for (int a : graph.adjList[j]) {
                indegArr[a]++;
            }
        }
//        System.out.println("Indegree: "+ Arrays.toString(indegArr));

        Queue<Integer> queue = new LinkedList<>();
        for (int j = 0; j < indegArr.length; j++) {
            if (indegArr[j] == 0) {
                queue.add(j);
            }
        }

        List<Integer> toposort = new LinkedList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            toposort.add(node);

            for (int neigh : graph.adjList[node]) {
                indegArr[neigh]--;
                if (indegArr[neigh] == 0) queue.add(neigh);
            }
        }
        System.out.println(toposort);
        return toposort;
    }
}
