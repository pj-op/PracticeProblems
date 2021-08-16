package com.graphs;

import java.util.LinkedList;
import java.util.Scanner;

public class GraphSimple {

	private static LinkedList<Integer> adj[] = null;
	private static Scanner scan = null;

	GraphSimple(int v) {
		adj = new LinkedList[v];

		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public static void addEdge(int src, int dest) {
		adj[src].add(dest);
		adj[dest].add(src);
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);

		System.out.println("Enter No. of vertices: ");
		int vertices = scan.nextInt();
		System.out.println("Enter No. of edges: ");
		int edge = scan.nextInt();

		GraphSimple graph = new GraphSimple(vertices);

		System.out.println("Enter " + edge + " edges");
		for (int i = 0; i < edge; i++) {
			int source = scan.nextInt();
			int destination = scan.nextInt();

			GraphSimple.addEdge(source, destination);
		}

	}
}
