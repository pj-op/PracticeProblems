package com.againpractice;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {

		int col = 4;
		int row = 8;
		int height = row + 1;
		drawPascalTriangle(col, row, height);
	}

	public static void drawPascalTriangle(int col, int row, int height) {

		List<List<Integer>> pascalList = new ArrayList<List<Integer>>();

		List<Integer> a = new ArrayList<>();
		a.add(1);
		pascalList.add(a);

		for (int i = 1; i < height; i++) {
			List<Integer> a2 = pascalList.get(i - 1);
			List<Integer> a3 = new ArrayList<>();
			a3.add(1);

			for (int j = 1; j < i; j++) {
				a3.add(a2.get(j - 1) + a2.get(j));
			}

			a3.add(1);

			pascalList.add(a3);
		}

//		pascalList.stream().forEach(System.out::println);
		System.out.println(pascalList.get(row).get(col));
	}

}
