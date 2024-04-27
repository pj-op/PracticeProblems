package com.maths;

public class PowerOf10 {

	public static void main(String[] args) {
		System.out.println(getPowerOf10(570));
	}

	public static boolean getPowerOf10(int a) {
		int b = 0;

		if (a < 10 && a > 1) {
			return false;
		}

		while (a > 0) {
			a = a / 10;
			b = a % 10;
			if (b > 0) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

}
