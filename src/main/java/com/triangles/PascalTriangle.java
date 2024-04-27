package com.triangles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {

	public static void main(String[] args) {

		List<List<Integer>> a = new ArrayList<>();
		List<Integer> a1 = new ArrayList<>();

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Height of Pascals triangle: ");
		int height = scan.nextInt();

		a1.add(1);
		a.add(a1);

		for (int i = 1; i < height + 1; i++) {
			List<Integer> a2 = a.get(i - 1);
			List<Integer> a3 = new ArrayList<>();

			a3.add(1);
			for (int j = 1; j < i; j++) {
				a3.add(a2.get(j - 1) + a2.get(j));
			}
			a3.add(1);

			a.add(a3);
		}

		a.stream().forEach(System.out::println);
		int col = 1;
		int row = 2;

		System.out.println(a.get(row).get(col));

		scan.close();
	}
}
