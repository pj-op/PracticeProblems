package com.GRAPH.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class MinimumNumberVerticesReachAllNodes {
    public static void main(String[] args) {
        int numOfEdges =
                6
//                5
//                3
                ;
        int[][] edges =
                {{0, 1}, {0, 2}, {2, 5}, {3, 4}, {4, 2}}
//                {{0, 1}, {2, 1}, {3, 1}, {1, 4}, {2, 4}}
//                {{1, 2}, {1, 0}, {0, 2}}
                ;

//        System.out.println(findSmallestSetOfVertices(numOfEdges, edges));
        System.out.println(calculateIndegreeAndReturnIndexWithZeroValue(numOfEdges, edges));
    }

    // Calculate in-degree and return index with 0
    private static List<Integer> calculateIndegreeAndReturnIndexWithZeroValue(int numOfEdges, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        int[] indegree = new int[numOfEdges];
        for (int[] a : edges) {
            indegree[a[1]]++;
        }
        IntStream.range(0, indegree.length)
                .filter(i -> indegree[i] == 0)
                .forEach(ans::add);
        return ans;
    }

    //This works only for DAG
    public static List<Integer> findSmallestSetOfVertices(int n, int[][] edges) {
        STF graph = new STF(n);
        for (int[] a : edges) {
            graph.addDirectedEdge(a[0], a[1]);
        }
//        System.out.println(Arrays.toString(graph.adjList));
        List<Integer> ans = new ArrayList<>();

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                ans.add(i);
                performBFS(i, visited, graph.adjList);
            }
        }

        return ans;
    }

    private static void performBFS(int i, boolean[] visited, List<Integer>[] adjList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
//            System.out.print(currNode + " ");
            for (int neigh : adjList[currNode]) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    queue.add(neigh);
                }
            }
        }
    }

}

class STF {
    int numOfNode;
    List<Integer>[] adjList;

    STF(int numOfNode) {
        this.numOfNode = numOfNode;
        this.adjList = new List[numOfNode];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList();
        }
    }

    public void addDirectedEdge(int src, int dest) {
        adjList[src].add(dest);
    }
}