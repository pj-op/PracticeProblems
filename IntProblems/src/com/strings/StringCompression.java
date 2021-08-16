package com.strings;

import java.util.Arrays;

public class StringCompression {

	public static void main(String[] args) {
		char[] s1 = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };

		compressString(s1);
	}

	public static void compressString(char[] s1) {
		StringBuilder sb = new StringBuilder();
		sb.append("");

		int i = 0;
		int j = 0;

		while (i < s1.length && j < s1.length) {

			char firstChar = s1[i];
			sb.append(firstChar);
			while (j < s1.length && s1[i] == s1[j])
				j++;
			int diff = j - i;
			if (diff > 1) {
				sb.append(diff);
			}

			i = j;
		}

//		char result[] = new char[sb.length()];

		System.out.println(sb.length());

		for (int k = 0; k < sb.length(); k++) {
			s1[k] = sb.charAt(k);
		}

		System.out.println(Arrays.toString(s1));
//		System.out.println(sb.toString().length());
	}
}
