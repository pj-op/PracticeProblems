package com.arrays;

import java.util.LinkedHashSet;

public class UniqueTuples {

	public static void main(String[] args) {
		String s1 = "abbccde";
		int i = 2;

		System.out.println(uniqueTuples(s1, i));
	}

	public static LinkedHashSet<String> uniqueTuples(String input, int len) {

		LinkedHashSet<String> s = new LinkedHashSet<>();
		
		for (int i = 0; i < input.length() - 1; i++) {
			s.add(input.substring(i, i + 2));
		}
		return s;
	}

}
