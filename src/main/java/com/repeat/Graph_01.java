package com.repeat;

import java.util.*;

public class Graph_01 {
    public static void main(String[] args) {
        GraphCl_01 graph = new GraphCl_01(8);
        graph.addDirectedEdge(0, 1);
        graph.addDirectedEdge(0, 2);
        graph.addDirectedEdge(0, 3);
        graph.addDirectedEdge(1, 3);
        graph.addDirectedEdge(2, 4);
        graph.addDirectedEdge(3, 5);
        graph.addDirectedEdge(3, 6);
        graph.addDirectedEdge(4, 7);
        graph.addDirectedEdge(4, 5);
        graph.addDirectedEdge(5, 2);

//        System.out.println(Arrays.toString(graph.adjList));
        int numOfNodes = graph.numOfNodes;
        boolean[] visited = new boolean[numOfNodes];
        Arrays.fill(visited, false);
        System.out.print("DFS: ");
        for (int i = 0; i < numOfNodes; i++) {
            if (!visited[i]) {
                performDFSOnGraphCl_01(i, graph.adjList, visited);
            }
        }
        System.out.println();
        Arrays.fill(visited, false);
        System.out.print("BFS: ");
        for (int i = 0; i < numOfNodes; i++) {
            if (!visited[i]) {
                performBFSOnGraphCl_01(i, graph.adjList, visited);
            }
        }
        System.out.println();

        int[][] forest = {
                {0, 0, 1, 0, 0, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 1, 0, 0, 1},
                {0, 1, 1, 1, 0, 1},
                {0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 1},

        };

        int m = forest.length;
        int countNumOfForest = 0;
        int n = forest[0].length;
        boolean[][] visitedArray = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest[i][j] != 0 && !visitedArray[i][j]) {
//                    countNumberOfForestUsingBFS(i, j, forest, visitedArray);
                    countNumberOfForestUsingDFS(i, j, forest, visitedArray);
                    countNumOfForest++;
                }
            }
        }
        System.out.println(Arrays.deepToString(visitedArray));
        System.out.println("Number of forest: " + countNumOfForest);
    }

    private static void countNumberOfForestUsingDFS(int row, int col, int[][] forest, boolean[][] visitedArray) {
        visitedArray[row][col] = true;
        int m = forest.length;
        int n = forest[0].length;

        int[] delRowArray = {-1, 0, 1, 0};
        int[] delColArray = {0, 1, 0, -1};

        for (int i = 0; i < delRowArray.length; i++) {
            int nRow = row + delRowArray[i];
            int nCol = col + delColArray[i];

            if (nRow < m && nRow >= 0 && nCol < n && nCol >= 0 && !visitedArray[nRow][nCol] && forest[nRow][nCol] != 0) {
                countNumberOfForestUsingDFS(nRow, nCol, forest, visitedArray);
            }
        }
    }

    private static void countNumberOfForestUsingBFS(int row, int col, int[][] forest, boolean[][] visitedArray) {
        Queue<NodePair_01> queue = new LinkedList<>();
        queue.add(new NodePair_01(row, col));
        int m = forest.length;
        int n = forest[0].length;

        while (!queue.isEmpty()) {
            NodePair_01 currNode = queue.poll();
            int currRow = currNode.row;
            int currCol = currNode.col;

            int[] delRowArr = {-1, 0, 1, 0};
            int[] delColArr = {0, 1, 0, -1};

            for (int i = 0; i < delRowArr.length; i++) {
                int nRow = currRow + delRowArr[i];
                int nCol = currCol + delColArr[i];


                if (nRow < m && nRow >= 0 && nCol < n && nCol >= 0 && !visitedArray[nRow][nCol] && forest[nRow][nCol] != 0) {
                    visitedArray[nRow][nCol] = true;
                    queue.add(new NodePair_01(nRow, nCol));
                }
            }
        }
    }

    private static void performDFSOnGraphCl_01(int node, List<Integer>[] adjList, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neigh : adjList[node]) {
            if (!visited[neigh]) {
                performDFSOnGraphCl_01(neigh, adjList, visited);
            }
        }
    }

    private static void performBFSOnGraphCl_01(int src, List<Integer>[] adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            System.out.print(currNode + " ");

            for (int neighbourNode : adjList[currNode]) {
                if (!visited[neighbourNode]) {
                    queue.add(neighbourNode);
                    visited[neighbourNode] = true;
                }
            }
        }
    }
}

class GraphCl_01 {
    int numOfNodes;
    List<Integer>[] adjList;

    GraphCl_01(int numOfNodes) {
        this.numOfNodes = numOfNodes;
        this.adjList = new List[numOfNodes];
        for (int i = 0; i < numOfNodes; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    void addDirectedEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    void addBidirectedEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }
}

class NodePair_01 {
    int row;
    int col;

    NodePair_01(int row, int col) {
        this.row = row;
        this.col = col;
    }
}