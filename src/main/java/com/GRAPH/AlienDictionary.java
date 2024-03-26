package com.GRAPH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class DictGraph {
    int vertex;
    List<Integer>[] adjList;

    DictGraph(int vertex) {
        this.vertex = vertex;
        this.adjList = new List[vertex];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList();
        }
    }

    public void addDirectedEdge(int src, int dest) {
        adjList[src].add(dest);
    }
}

public class AlienDictionary {
    public static void main(String[] args) {
        String[] dict ={"wrt","wrf","er","ett","rftt"};
                //{"baa", "abcd", "abca", "cab", "cad"};
        pairComparison(dict);
    }

    private static void pairComparison(String[] dict) {

        DictGraph graph = new DictGraph(23);

        for (int i = 0; i + 1 < dict.length; i++) {
            String firstElement = dict[i];
            String secondElement = dict[i + 1];

            int mLength = firstElement.length();
            int nLength = secondElement.length();

            for (int j = 0; j < Math.min(mLength, nLength); j++) {
                char fChar = firstElement.charAt(j);
                char sChar = secondElement.charAt(j);

                if (fChar != sChar) {
                    graph.addDirectedEdge(fChar - 'a', sChar - 'a');
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(graph.adjList));

        StringBuilder ans = new StringBuilder();
        for (int a : findTopoSort(graph)) {
            ans.append((char) (a + 'a'));
        }

        System.out.println(ans);

    }

    private static List<Integer> findTopoSort(DictGraph graph) {

        int[] inDegreeArray = new int[graph.vertex];
        for (int i = 0; i < inDegreeArray.length; i++) {
            for (int neigh : graph.adjList[i]) {
                inDegreeArray[neigh]++;
            }
        }

//        System.out.println("Indegree Node wise: " + Arrays.toString(inDegreeArray));

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegreeArray.length; i++) {
            int j = inDegreeArray[i];
            if (j == 0) {
                queue.add(i);
            }
        }

//        System.out.println("Queue: " + queue);
//        System.out.println("AdjacencyList: " + Arrays.toString(graph.adjList));

        List<Integer> toposort = new LinkedList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            toposort.add(node);

            for (int neigh : graph.adjList[node]) {
                inDegreeArray[neigh]--;
                if (inDegreeArray[neigh] == 0) {
                    queue.add(neigh);
                }
            }
        }

//        System.out.println("Toposort: "+toposort);
        return toposort;
    }
}
