package com.GRAPH.graphs;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LargestColorValueInDirectedGraph {
    public static void main(String[] args) {
//        String colors = "abaca"; int[][] edges = {{0, 2}, {0, 1}, {2, 3}, {3, 4}};
        String colors = "hhqhuqhqff";
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {3, 4}, {3, 5}, {5, 6}, {2, 7}, {6, 7}, {7, 8}, {3, 8}, {5, 8}, {8, 9}, {3, 9}, {6, 9}};
//        String colors = "a"; int [][] edges = {{0,0}};

        System.out.println(largestPathValueSolution(colors, edges));

    }

    private static int largestPathValueSolution(String colors, int[][] edges) {
        int ans = 0;
        int nodesVisited = 0;
        int numOfNodes = colors.length();
        int[] inDegree = new int[numOfNodes];
        int[][] countColor = new int[numOfNodes][26];
        List<List<Integer>> adjList = new ArrayList<>();

        //AdjList and inDegree Array Initialization
        for (int i = 0; i < numOfNodes; i++) {
            adjList.add(new ArrayList<>());
            inDegree[i] = 0;
        }

        //Creating Adjacency List and inDegree
        for (int[] arr : edges) {
            adjList.get(arr[0]).add(arr[1]);
            inDegree[arr[1]]++;
        }

        //Toposorting - STARTS
        Queue<ColorNode> queue = new LinkedList<>();

        //Adding 0 - InDegree Index to queue
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(new ColorNode(i, colors.charAt(i)));
            }
        }

        //BFS
        while (!queue.isEmpty()) {
            ColorNode colorNode = queue.poll();
            int currNode = colorNode.getNode();
            int currColor = colorNode.getColor();
            ans = Math.max(ans, ++countColor[currNode][currColor - 'a']);
            inDegree[currNode]--;
            nodesVisited++;

            for (int neigh : adjList.get(currNode)) {
                for (int i = 0; i < 26; i++) {
                    countColor[neigh][i] = Math.max(countColor[neigh][i], countColor[currNode][i]);
                }
                inDegree[neigh]--;
                if (inDegree[neigh] == 0) {
                    queue.add(new ColorNode(neigh, colors.charAt(neigh)));
                }
            }
        }


        return nodesVisited < numOfNodes ? -1 : ans;
    }

    private static int[] calculateInDegreeOfEveryNode(int numVertex, int[][] edges) {
        int[] inDegree = new int[numVertex];
        for (int[] a : edges) {
            inDegree[a[1]]++;
        }
        return inDegree;
    }

    private static List<List<Integer>> prepareAdjListOfGivenEdge(String colors, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        int numOfVertex = colors.length();
        for (int i = 0; i < numOfVertex; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] a : edges) {
            adjList.get(a[0]).add(a[1]);
        }
        return adjList;
    }
}

class ColorNode {
    int node;
    char color;

    public ColorNode(int node, char color) {
        this.node = node;
        this.color = color;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColorNode{" +
                "node=" + node +
                ", color=" + color +
                '}';
    }
}