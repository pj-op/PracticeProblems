package com.practice;

public class StringCompression {

	public static void main(String[] args) {
		char a[] = { 'a', 'a', 'b', 'b', 'c', 'c', 'c', 'a', 'a' };

		char a2[] = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };

		System.out.println(new StringCompression().compressString(a));
	}

	public String compressString(char[] charArray) {

		StringBuilder sb = new StringBuilder();
		sb.append("");
		int i = 0;
		int j = 0;

		while (i < charArray.length && j < charArray.length) {
			char a = charArray[i];
			sb.append(a);

			while (j < charArray.length && charArray[i] == charArray[j]) {
				j++;
			}
			int diff = j - i;
			if (diff > 1) {
				sb = sb.append(diff);
			}
			i = j;
		}
		return sb.toString();

	}

}
