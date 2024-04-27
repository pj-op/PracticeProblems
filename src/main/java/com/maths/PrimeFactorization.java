package com.maths;

import java.util.ArrayList;

public class PrimeFactorization {
	public static void main(String[] args) {
		System.out.println(primeFactorization(1305744254));
//		System.out.println(isUgly(1332185066));
//		System.out.println(optimalIsUgly(1305744254));

//		IntStream.rangeClosed(2, 100)
//				.filter(s -> IntStream.rangeClosed(2, (int) (Math.sqrt(s))).noneMatch(x -> s % x == 0))
//				.forEach(System.out::println);

	}

	public static ArrayList<Integer> primeFactorization(int x) {

		ArrayList<Integer> a = new ArrayList<>();

		int num = x;
		int i = 0;

		/*
		 * if(num ==1) { return true; }
		 */

		for (i = 2; i < x; i++) {
			while (num % i == 0) {
//				System.out.print(i + " ");
				a.add(i);
				num = num / i;
			}
		}
		if (num > 2) {
//			System.out.println(num);
			a.add(num);
		}

		return a;
	}

	public static boolean isUgly(int x) {
//		ArrayList<Integer> a = new ArrayList<>();
		int i = 0;
		int num = x;

		if (num == 1) {
			return true;
		} else if (num <= 0) {
			return false;
		}

		for (i = 2; i < x; i++) {
			while (num % i == 0) {
//				a.add(i);
				if (i > 5) {
					return false;
				}
				num = num / i;
			}
		}
		if (num > 2) {
//			a.add(num);
			if (i > 5) {
				return false;
			}
		}

//		System.out.println(a);

		return true;
	}

	public static boolean optimalIsUgly(int num) {

		if (num <= 0) {
			return false;
		}

		int[] a = { 2, 3, 5 };

		for (int p : a) {
			while (num % p == 0) {
				num = num / p;
			}
		}
		return num == 1;
	}
}
