package com.maths;

public class Factorial {

	public static void main(String[] args) {
		int a = 4;
		System.out.println(factorial(a));

	}

	public static int factorial(int a) {

		if (a == 0) {
			return 1;
		}

		return a * factorial(a - 1);
	}

}
