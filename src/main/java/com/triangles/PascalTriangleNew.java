package com.triangles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangleNew {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter Height: ");
		int height = scan.nextInt();
		System.out.print("Enter Row: ");
		int row = scan.nextInt();
		System.out.print("Enter Col: ");
		int col = scan.nextInt();

		List<List<Integer>> nodeList = new ArrayList<>();
		List<Integer> a1 = new ArrayList<>();

		a1.add(1);
		nodeList.add(a1);

		for (int i = 1; i < height + 1; i++) {
			List<Integer> a2 = nodeList.get(i - 1);
			List<Integer> a3 = new ArrayList<>();

			a3.add(1);
			for (int j = 1; j < i; j++) {
				a3.add(a2.get(j - 1) + a2.get(j));
			}
			a3.add(1);
			nodeList.add(a3);
		}

		nodeList.stream().forEach(System.out::println);

		System.out.println(nodeList.get(row).get(col));

		scan.close();
	}

}
