package com.maths;

public class SquareRoot {

	public static void main(String[] args) {
		int number = 3;
		double num1 = 0;
		double num2 = number / 2;

		do {
			num1 = num2;
			num2 = (num1 + (number / num1)) / 2;
		} while ((num1 - num2) != 0);

		System.out.println(num2);
	}
}
