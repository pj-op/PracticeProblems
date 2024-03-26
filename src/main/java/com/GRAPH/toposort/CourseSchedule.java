package com.GRAPH.toposort;

//https://leetcode.com/problems/course-schedule/

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
//        int numCourses = 2; int[][] prerequisites = {{1, 0}};
        int numCourses = 2;        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjList = prepareAdjList(numCourses, prerequisites);
        int[] inDegree = new int[numCourses];
        List<Integer> topoSort = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (List<Integer> a : adjList) {
            for (int b : a) {
                inDegree[b]++;
            }
        }
        System.out.println(Arrays.toString(inDegree));

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            inDegree[currNode]--;
            topoSort.add(currNode);

            for (int a : adjList.get(currNode)) {
                inDegree[a]--;
                if (inDegree[a] == 0) {
                    queue.add(a);
                }
            }
        }


        return topoSort.size() == numCourses;
    }

    private static List<List<Integer>> prepareAdjList(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }

//        System.out.println(adjList);

        return adjList;
    }
}
