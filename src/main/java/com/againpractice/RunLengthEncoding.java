package com.againpractice;

public class RunLengthEncoding {

	/*
	 * Problem Statement- For a string input the function returns output encoded as
	 * follows:
	 *
	 * Test Cases:
	 * "a" -> "a1"
	 * "aa" -> "a2"
	 * "aabbb" -> "a2b3"
	 * "aabbbaa" -> "a2b3a2"
	 * 
	 * Signature : String rle(String input) { }
	 * 
	 * Test Case: Input : aaabbbaad Output: a3b3a2d1
	 */

	public static void main(String[] args) {

		String s = "";
		compressString(s);
	}

	public static void compressString(String str) {

		if (str.isEmpty()) {
			return;
		}

		int i = 0;
		int j = 0;
		StringBuilder sb = new StringBuilder();

		while (i < str.length() && j < str.length()) {
			sb.append(str.charAt(i));

			while (j < str.length() && str.charAt(i) == str.charAt(j)) {
				j++;
			}
			int diff = j - i;
			sb.append(diff);
			i = j;
		}

		System.out.println(sb.toString());

	}

}
