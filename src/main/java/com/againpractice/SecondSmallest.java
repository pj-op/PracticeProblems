package com.againpractice;

public class SecondSmallest {
	public static void main(String[] args) {

		int[] num = { 1, 0, 1, -2, 2 };
		int comp = Integer.MAX_VALUE;

		for (int x : num) {
			if (x < comp) {
				comp = x;
			}
		}

		System.out.println(comp);
	}

}
