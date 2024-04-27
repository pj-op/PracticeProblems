package com.arrays;

public class SmallestNumber {
	public static void main(String[] args) {

		int a[] = { 1, 3, 5, 6, 0, -1 };
		int min = Integer.MAX_VALUE;

		for (int c : a) {
			min = Math.min(min, c);
		}
		System.out.println(min);
	}
}
