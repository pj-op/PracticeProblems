package com.GRAPH;

import java.util.*;

public class SimpleGraphTest {
    public static void main(String[] args) {
        Graphing graph = new Graphing(7);

        graph.addEdge(1, 0);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(5, 3);
        graph.addEdge(6, 1);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 6);

//        graph.printGraph();


        depthFirstSearch(5, 4, Arrays.asList(
                Arrays.asList(0, 2),
                Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(3, 4)
        ));

    }

    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, List<List<Integer>> edges) {
        // Write your code here.

        /*Sample Input
        5 4
        0 2
        0 1
        1 2
        3 4*/


        //Prepare Adjacency List
        ArrayList[] adjList = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList();
        }
        for (int i = 0; i < edges.size(); i++) {
            int a = edges.get(i).get(0);
            int b = edges.get(i).get(1);

            adjList[a].add(b);
            adjList[b].add(a);
        }

        System.out.println(Arrays.toString(adjList));

        //Returning list
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Map<Integer, Boolean> visitedMap = new HashMap<>();
        ArrayList<Integer> component;
        for (int i = 0; i < v; i++) {
            visitedMap.put(i, false);

            if (!visitedMap.get(i)) {
                component = new ArrayList<>();
                dfs(i, visitedMap, adjList, component);
                ans.add(component);
            }

        }
        return ans;
    }

    private static void dfs(int i, Map<Integer, Boolean> visitedMap, ArrayList[] adjList, List<Integer> component) {

        component.add(i);
        visitedMap.put(i, true);

        for (Object x : adjList[i]) {
            if (!visitedMap.get(x)) {
//                dfs(x, visitedMap, adjList, component);
            }
        }

    }


}
class Graphing {
    private int vertexNumber;
    private LinkedList<Integer>[] adjList;

    Graphing(int vertexNumber) {
        this.vertexNumber = vertexNumber;
        this.adjList = new LinkedList[vertexNumber];
        for (int i = 0; i < vertexNumber; i++) {
            adjList[i] = new LinkedList();
        }
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    public void printGraph() {
        for (int i = 0; i < vertexNumber; i++) {
            System.out.print(" neighbours of vertex :" + i);
            for (Integer vertex : adjList[i]) {
                System.out.print(" " + vertex + " ");
            }
            System.out.println();
        }
    }
}

