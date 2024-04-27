package com.maths;

public class PowExponential {

	public static void main(String[] args) {
//		System.out.println(power(2, 4));
//		System.out.println(rec(2, 4));
		System.out.println(powerOptimal(-2,5));
//		System.out.println(doTestsPass());
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("There are test failures");
		}
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

	public static double powerOptimal(double base, int exp) {
		double num;
		if (exp == 0) {
			return 1;
		}
		num = power(base, Math.abs(exp) / 2);
//		System.out.println(num);
		double ans;
		if (exp % 2 == 0) {
			ans = num * num;
		} else {
			ans = base * num * num;
		}
		return exp < 0 ? 1 / ans : ans;
	}

	public static boolean doTestsPass() {
		// todo: implement more tests, please
		// feel free to make testing more elegant
		boolean testsPass = true;
		double result = powerOptimal(2, 2);
		double result1 = powerOptimal(-3, 2);
		double result2 = powerOptimal(0, 2);
		double result3 = powerOptimal(2, 3);
		double result4 = powerOptimal(-2, 3);
		double result5 = powerOptimal(2, -2);
		double result6 = powerOptimal(-2, -2);
		double result7 = powerOptimal(-2, -3);
		double result8 = powerOptimal(2.5, 2);
		// 4,7 = 4*4*4*4*4*4*4 ->
		return testsPass && result == 4 && result1 == 9 && result2 == 0 && result3 == 8 && result4 == -8
				&& result5 == 0.25 && result6 == 0.25 && result7 == -0.125 && result8 == 6.25;
	}

}
