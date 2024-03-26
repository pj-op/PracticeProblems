package com.GRAPH.toposort;

import java.lang.reflect.Array;
import java.util.*;

//https://leetcode.com/problems/parallel-courses-iii/
public class ParallelCoursesIII {
    public static void main(String[] args) {
//        int n = 3;
//        int[][] relations = {{1, 3}, {2, 3}};
//        int[] time = {3, 2, 5};

        int n = 5;
        int[][] relations = {{1, 5}, {2, 5}, {3, 5}, {3, 4}, {4, 5}};
        int[] time = {1, 2, 3, 4, 5};

        System.out.println(minimumTimeOptimal(n, relations, time));
    }

    private static int minimumTimeOptimal(int n, int[][] relations, int[] time) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[n + 1];
        for (int[] arr : relations) {
            graph.computeIfAbsent(arr[0], ArrayList::new).add(arr[1]);
            inDegree[arr[1]]++;
        }
        System.out.println(graph);
        int[] dist = new int[n + 1];
        System.arraycopy(time, 0, dist, 1, n);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            inDegree[currNode]--;

            if (graph.containsKey(currNode)) {
                for (int neigh : graph.get(currNode)) {
                    dist[neigh] = Math.max(dist[neigh], dist[currNode] + time[neigh - 1]);
                    inDegree[neigh]--;
                    if (inDegree[neigh] == 0) {
                        queue.add(neigh);
                    }
                }
            }
        }
        return Arrays.stream(dist).max().getAsInt();
    }

    public static int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adjList = prepareAdjListForParallelCourse(n, relations);
        System.out.println(adjList);
        //Calculate In-degree
        int[] inDegree = new int[n + 1];
        for (List<Integer> a : adjList) {
            for (int element : a) {
                inDegree[element]++;
            }
        }
        int[] dist = new int[n + 1];
        System.arraycopy(time, 0, dist, 1, n);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            inDegree[currNode]--;

            for (int neigh : adjList.get(currNode)) {
                dist[neigh] = Math.max(dist[neigh], dist[currNode] + time[neigh - 1]);
                inDegree[neigh]--;
                if (inDegree[neigh] == 0) {
                    queue.add(neigh);
                }
            }
        }
        return Arrays.stream(dist).max().getAsInt();
    }

    private static List<List<Integer>> prepareAdjListForParallelCourse(int n, int[][] relations) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] a : relations) {
            adjList.get(a[0]).add(a[1]);
        }
        return adjList;
    }
}
