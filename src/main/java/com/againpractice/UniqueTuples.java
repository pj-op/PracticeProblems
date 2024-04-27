package com.againpractice;

import java.util.HashSet;

public class UniqueTuples {
	public static void main(String[] args) {

		String str = "abc";
		int size = 2;

		getUniqueTuples(str, size);
	}

	private static void getUniqueTuples(String str, int size) {
		
		HashSet<String> tuples = new HashSet<>();
		
		for (int i = 0; i < str.length() - 1; i++) {
			tuples.add(str.substring(i, i + size));
		}
		
		System.out.println(tuples);
	}

}
