package com.maths;

public class PowerOf2 {

	public static void main(String[] args) {
		int n = 128;
		int check = 0;

		if (n <= 0) {
			System.out.println(false);
		}

		while (n > 0) {
			check = n % 2;
			n = n / 2;
			if (check > 0) {
				break;
			}
		}

		if (check == 0 || n == 0) {
			System.out.println(true);
		}
		System.out.println(false);

	}

	// Optimal Solution
	public boolean isPowerOfTwo(int n) {
		return ((n & (n - 1)) == 0 && n > 0);
	}
}
//And operation of a number into the number -1 will be 0 in the case of multiplier of 2