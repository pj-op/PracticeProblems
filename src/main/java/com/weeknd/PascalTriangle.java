package com.weeknd;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		drawPascal(10);
	}

	public static void drawPascal(int height) {

		List<List<Integer>> pascalTrinagle = new ArrayList<>();
		List<Integer> a1 = new ArrayList<>();

		a1.add(1);
		pascalTrinagle.add(a1);

		for (int i = 1; i < height; i++) {
			List<Integer> a2 = pascalTrinagle.get(i - 1);
			List<Integer> a3 = new ArrayList<>();

			a3.add(1);
			for (int j = 1; j < i; j++) {
				a3.add(a2.get(j - 1) + a2.get(j));
			}

			a3.add(1);
			pascalTrinagle.add(a3);
		}

		pascalTrinagle.forEach(System.out::println);
		System.out.println(pascalTrinagle.get(8).get(4));

	}
}
