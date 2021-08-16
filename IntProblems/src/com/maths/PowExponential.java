package com.maths;

public class PowExponential {

	public static void main(String[] args) {
		System.out.println(power(2, 4));
		System.out.println(rec(2, 4));
	}

	public static double power(double a, int power) {
		double result = 1;

		for (int i = 1; i <= power; i++) {
			result = result * a;
		}

		return result;
	}

	public static double rec(double a, int power) {
		if (power == 0) {
			return 1;
		}

		return a * rec(a, power - 1);

	}

}
