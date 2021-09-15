package com.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreePractice {

	static Scanner scanner = null;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		NodeM root = createTree();

		System.out.println("Level Order Traversal: ");
		levelOrder(root);
		System.out.println();
		System.out.println("Inorder traversal: ");
		inOrder(root);
		System.out.println();
		System.out.println("PreOrder traversal: ");
		preOrder(root);
		System.out.println();
		System.out.println("PostOrder traversal: ");
		postOrder(root);

	}

	public static NodeM createTree() {

		System.out.println("Enter Data: ");
		int data = scanner.nextInt();
		if (data == -1) {
			return null;
		}

		NodeM root = new NodeM(data);
		System.out.println("Enter Data for Left: " + data);
		root.left = createTree();
		System.out.println("Enter Data for right: " + data);
		root.right = createTree();

		return root;
	}

	public static void levelOrder(NodeM root) {
		Queue<NodeM> q = new LinkedList<NodeM>();
		if (root == null) {
			return;
		}
		q.add(root);

		while (!q.isEmpty()) {
			NodeM currentNode = q.poll();
			if (currentNode.left != null) {
				q.add(currentNode.left);
			}
			if (currentNode.right != null) {
				q.add(currentNode.right);
			}
			System.out.print(currentNode.data + " ");
		}

	}

	public static void inOrder(NodeM root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);

	}

	public static void preOrder(NodeM root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);

	}

	public static void postOrder(NodeM root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");

	}
}

class NodeM {
	NodeM left;
	NodeM right;
	int data;

	NodeM(int data) {
		this.data = data;
	}
}