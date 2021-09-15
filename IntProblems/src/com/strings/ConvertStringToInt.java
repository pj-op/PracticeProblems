package com.strings;

public class ConvertStringToInt {

	public static void main(String[] args) {
		String a = "-2147483648";
		System.out.println(convertStringToInt(a));
	}

	public static int convertStringToInt(String str) {

		int num = 0;
		boolean negative = false;
		int checkNum = 0;

		if (str.charAt(0) == '-') {
			negative = true;
			checkNum = 1;
		}

		for (int i = checkNum; i < str.length(); i++) {
			num = num * 10 + (int) str.charAt(i) - '0';
		}

		if (negative) {
			num = num * -1;
		}

		return num;

	}
}
