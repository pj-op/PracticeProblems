package com.strings;

// 6. Longest Uniform Substring

public class LongestUniformSubstring {

	public static void main(String[] args) {

		int[] res = longetstUniformSubString("aaBBBBBCdaaqqqqqqqqqqqqqqqqqq");
		System.out.println(res[0] + "," + res[1]);

	}

	private static int[] longetstUniformSubString(String line) {

		int[] result = new int[2];
		int index = 0;

		char[] input = line.toCharArray();
		int count = 1;
		for (int i = 1; i < input.length; i++) {
			if (input[i] != input[index]) {
				index = i;
				count = 1;
			} else {
				count++;
				System.out.println("Else");
			}

			if (count > result[1]) {
				result[1] = count;
				result[0] = index;
			}

		}
		return result;
	}

}
