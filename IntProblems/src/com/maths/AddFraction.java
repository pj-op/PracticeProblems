package com.maths;

public class AddFraction {

	public static void main(String[] args) {

		int f1[] = { 5, 8 };
		int f2[] = { 3, 10 };

		int max = f1[1] > f2[1] ? f1[1] : f2[1];
		int min = f1[1] < f2[1] ? f1[1] : f2[1];

//		int lcm = max % min == 0 ? max : min * max;
		int lcm = lcm(max, min);

//		System.out.println(lcm);

		int a = lcm / f1[1] * f1[0];
		int b = lcm / f2[1] * f2[0];

//		System.out.println(a + "" + b);

		int numerator = a + b;
		int gcd = gcd(numerator, lcm);

		if (numerator % gcd == 0 && lcm % gcd == 0) {
			numerator = numerator / gcd;
			lcm = lcm / gcd;
		}

		System.out.println(numerator + "/" + lcm);
	}

	public static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}

	public static int lcm(int a, int b) {
		return (a / gcd(a, b) * b);
	}

}
