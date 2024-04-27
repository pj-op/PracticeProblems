package com.strings;

public class PrintPermutationOfStrings {

	public static void main(String[] args) {
		String s = "ab";
		printAllCombos(s, "");
	}

	public static void printAllCombos(String str, String asf) {
		if (str.length() == 0) {
			System.out.println(asf);
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			String firstIndex = str.substring(0, i);
			String secondIndex = str.substring(i + 1);
			String result = firstIndex + secondIndex;
			printAllCombos(result, ch + asf);
		}

	}

}
