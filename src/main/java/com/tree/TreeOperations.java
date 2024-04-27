package com.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeOperations {

	static Scanner scan = null;

	public static void main(String[] args) {
		scan = new Scanner(System.in);

		NodeMM root = createTree();
		System.out.println("Inorder Travarsal: ");
		inOrder(root);
		System.out.println();
		System.out.println("Pre Order Traversal: ");
		preOrder(root);
		System.out.println();
		System.out.println("Post Order Traversal: ");
		postOrder(root);
		System.out.println();
		System.out.println("Level Order Traversal: ");
		levelOrder(root);
	}

	public static NodeMM createTree() {
		int data = 0;
		NodeMM root = null;
		System.out.println("Enter Data: ");
		data = scan.nextInt();
		if (data == -1) {
			return null;
		}
		root = new NodeMM(data);
		System.out.println("Enter Data For Left: " + data);
		root.left = createTree();
		System.out.println("Enter Data For right: " + data);
		root.right = createTree();

		return root;
	}

	public static void inOrder(NodeMM root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public static void preOrder(NodeMM root) {
		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void postOrder(NodeMM root) {
		if (root == null) {
			return;
		}

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	public static void levelOrder(NodeMM root) {

		if (root == null) {
			return;
		}
		Queue<NodeMM> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			NodeMM x = q.poll();
			if (x.left != null) {
				q.add(x.left);
			}
			if (x.right != null) {
				q.add(x.right);
			}
			System.out.print(x.data + " ");
		}
	}
}

class NodeMM {
	NodeMM left, right;
	int data;

	public NodeMM(int data) {
		this.data = data;
	}
}