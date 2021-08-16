package com.maths;

public class GCD {

	public static void main(String[] args) {

		int a = 15;
		int b = 20;

		System.out.println(gcd(a, b));
		System.out.println(lcm(a, b));

	}

	public static int gcd(int x, int y) {

		if (x == 0) {
			return y;
		}

		System.out.println("x: " + x + "----- y: " + y);

		return gcd(y % x, x);
	}

	public static int lcm(int a, int b) {
		return ((a / gcd(a, b)) * b);
	}
}
