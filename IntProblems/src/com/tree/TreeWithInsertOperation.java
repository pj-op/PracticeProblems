package com.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeWithInsertOperation {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		Node root = createTree();

		System.out.println("InOrder Traversal: ");
		inOrder(root);
		System.out.println();
		System.out.println("PreOrder Traversal: ");
		preOrder(root);
		System.out.println();
		System.out.println("PostOrder Traversal: ");
		postOrder(root);
		System.out.println();
		System.out.println("Level Order Traversal: ");
		levelOrder(root);
		System.out.println();
		System.out.println("Enter Data to be added to the tree: ");
		int newData = scanner.nextInt();
		Node c = insertNode(root, newData);

		System.out.println("InOrder Traversal: ");
		inOrder(c);
		System.out.println();
		System.out.println("PreOrder Traversal: ");
		preOrder(c);
		System.out.println();
		System.out.println("PostOrder Traversal: ");
		postOrder(c);
		System.out.println();
		System.out.println("Level Order Traversal: ");
		levelOrder(c);
		System.out.println();
		System.out.println(containsNode(c, 145));

	}

	private static Node createTree() {
		System.out.println("Enter Data: ");

		int data = scanner.nextInt();
		if (data == -1) {
			return null;
		}

		Node root = new Node(data);
		System.out.println("Enter data for left: " + data);
		root.left = createTree();
		System.out.println("Enter data for right: " + data);
		root.right = createTree();

		return root;
	}

	private static void inOrder(Node root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	private static void preOrder(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	private static void postOrder(Node root) {
		if (root == null) {
			return;
		}

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	private static void levelOrder(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			Node x = q.poll();

			if (x.left != null) {
				q.add(x.left);
			}
			if (x.right != null) {
				q.add(x.right);
			}

			System.out.print(x.data + " ");
		}
	}

	private static Node insertNode(Node a, int data) {
		if (a == null) {
			return new Node(data);
		}

		if (data > a.data) {
			a.right = insertNode(a.right, data);
		} else if (data < a.data) {
			a.left = insertNode(a.left, data);
		}

		return a;
	}

	private static boolean containsNode(Node root, int fData) {
		if (root == null) {
			return false;
		}
		boolean flag = false;

		if (fData < root.data) {
			containsNode(root.left, fData);
		}
		if (root.data == fData) {
			flag = true;

		}
		if (fData > root.data) {
			containsNode(root.right, fData);
		}

		return flag;

	}
}

class Node {
	Node right, left;
	int data;

	Node(int data) {
		this.data = data;
	}
}
