package com.tree;

import java.util.*;

public class ValidateBinaryTreeNodes {
    public static void main(String[] args) {
//        int n = 4;
//        int[] leftChild = {1, -1, 3, -1};
//        int[] rightChild = {2, -1, -1, -1};

        /*int n = 2;
        int[] leftChild = {1, 0};
        int[] rightChild = {-1, -1};*/

        int n = 4;
        int[] leftChild = {3, -1, 1, -1};
        int[] rightChild = {-1, -1, 0, -1};

        System.out.println(validateBinaryTreeNodesExact(n, leftChild, rightChild));
    }

    private static boolean validateBinaryTreeNodesExact(int n, int[] leftChild, int[] rightChild) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        int root = findRoot(n, leftChild, rightChild);
        System.out.println(root);
        if (root == -1) return false;
        queue.add(root);

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            if (visited.contains(currNode)) return false;
            visited.add(currNode);
            if (leftChild[currNode] != -1) queue.add(leftChild[currNode]);
            if (rightChild[currNode] != -1) queue.add(rightChild[currNode]);
        }
        System.out.println(visited);
        return n == visited.size();
    }

    private static int findRootOld(int n, int[] left, int[] right) {
        Set<Integer> children = new HashSet<>();
        for (int node : left) children.add(node);
        for (int node : right) children.add(node);
        for (int i = 0; i < n; i++) {
            if (!children.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    private static int findRoot(int n, int[] left, int[] right) {
        Set<Integer> child = new HashSet<>();
        for (int a : left) if (a != -1) child.add(a);
        for (int a : right) if (a != -1) child.add(a);
        for (int i = 0; i < n; i++) if (!child.contains(i)) return i;
        return -1;
    }

    //Below solution doesn't satisfy all the test cases
    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree = new int[n];
        for (int a : leftChild) {
            if (a != -1) inDegree[a]++;
        }
        for (int a : rightChild) {
            if (a != -1) inDegree[a]++;
        }
        System.out.println(Arrays.toString(inDegree));
//        System.out.println(Arrays.deepToString(adjList));
        for (int a : inDegree) {
            if (a > 1) return false;
        }
        return true;
    }
}
