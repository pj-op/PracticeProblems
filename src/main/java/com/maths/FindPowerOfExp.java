package com.maths;

public class FindPowerOfExp {

	public static double power(double base, int exp) {
		double prod = 1.0;

		if (exp == 0)
			return 1;

		int x = Math.abs(exp);

		while (x > 0) {
			prod = prod * base;
			x--;
		}
		return exp < 0 ? 1 / prod : prod;
	}

	/*
	 * public static double power(double base, int exp) { double num; if (exp == 0)
	 * { return 1; } num = power(base, exp < 0 ? -1 * exp / 2 : exp / 2);
	 * System.out.println("Num: " + num); double ans; if (exp % 2 == 0) { ans = num
	 * * num; } else { ans = base * num * num; } return exp < 0 ? 1 / ans : ans; }
	 */

	/* returns true if all tests pass, false otherwise */
	public static boolean doTestsPass() {
		// todo: implement more tests, please
		// feel free to make testing more elegant
		boolean testsPass = true;
		double result = power(2, 2);
		double result1 = power(-3, 2);
		double result2 = power(0, 2);
		double result3 = power(2, 3);
		double result4 = power(-2, 3);
		double result5 = power(2, -2);
		double result6 = power(-2, -2);
		double result7 = power(-2, -3);
		double result8 = power(2.5, 2);
		double result9 = power(8, -3);
		// 4,7 = 4*4*4*4*4*4*4 ->
		return testsPass && result == 4 && result1 == 9 && result2 == 0 && result3 == 8 && result4 == -8
				&& result5 == 0.25 && result6 == 0.25 && result7 == -0.125 && result8 == 6.25 && result9 == 0.001953125;
	}

	public static void main(String[] args) {
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("There are test failures");
		}

//		System.out.println(7 << 2);
	}

}
