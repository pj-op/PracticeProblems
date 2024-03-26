package com.tree;

import java.util.*;


public class FindLargestValueEachTreeRow {
    public static void main(String[] args) {
        int[] root = {1, 3, 2, 5, 3, -1, 9};

        TreeNode rootNode = creatingTree(root);

        System.out.println(rootNode);

        Queue<TreeNode> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2.val, o1.val)));

    }

    private static TreeNode creatingTree(int[] arr) {
        int i = 0;
        TreeNode root = null;

        while (i < arr.length) {
            int data = arr[i++];
            if (data == -1) {
                return null;
            }
            root = new TreeNode(data);
            root.left = creatingTree(arr);
            root.right = creatingTree(arr);
        }
        return root;
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();


        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

}