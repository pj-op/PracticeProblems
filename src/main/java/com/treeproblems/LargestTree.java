package com.treeproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LargestTree {

	public static void main(String args[]) {

		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		mp.put(1, 2);
		mp.put(3, 1);
		mp.put(4, 2);
		mp.put(5, 6);
		mp.put(7, 6);
		mp.put(8, 9);
		largestTree(mp);
	}

	public static void largestTree(final Map<Integer, Integer> immediateParent) {

		Map<Integer, ArrayList<Integer>> trees = new HashMap<Integer, ArrayList<Integer>>();

		Map<Integer, Integer> vertexCount = new HashMap<Integer, Integer>();

		for (Map.Entry<Integer, Integer> es : immediateParent.entrySet()) {

			if (trees.containsKey(es.getValue())) {
				trees.get(es.getValue()).add(es.getKey());
			} else {
				ArrayList<Integer> arr = new ArrayList<Integer>();
				arr.add(es.getKey());
				trees.put(es.getValue(), arr);
			}

			if (!immediateParent.containsKey(es.getValue())) {
				vertexCount.put(es.getValue(), 0);
			}
		}

		for (Map.Entry<Integer, Integer> es : vertexCount.entrySet()) {

			vertexCount.put(es.getKey(), es.getValue() + DFS(es.getKey(), trees));

		}

		for (Map.Entry<Integer, Integer> es : vertexCount.entrySet()) {
			System.out.println("Parent : " + es.getKey() + " Value : " + es.getValue());
		}

		for (Map.Entry<Integer, ArrayList<Integer>> es : trees.entrySet()) {
			System.out.println("Parent : " + es.getKey() + " Value : " + es.getValue());
		}
	}

	private static Integer DFS(Integer root, Map<Integer, ArrayList<Integer>> trees) {

		Integer count = 1;

		if (trees.get(root) != null) {
			for (int i = 0; i < trees.get(root).size(); i++) {
				count += DFS(trees.get(root).get(i), trees);
			}
		}
		return count;
	}
}
