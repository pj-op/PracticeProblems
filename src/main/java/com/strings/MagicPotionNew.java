package com.strings;

public class MagicPotionNew {

	public static void main(String[] args) {
		String s1 = "ABCABCDABCD";

		getEncodedString(s1);

	}

	private static void getEncodedString(String s1) {

		StringBuilder sb = new StringBuilder();
		sb.append("");
		int count = 1;
		int i = 1;
		sb.append(s1.charAt(0));

		while (i < s1.length()) {
			if (s1.length() >= 2 * i && s1.charAt(i) == s1.charAt(0)) {
				if (s1.substring(0, i).equals(s1.substring(i, 2 * i))) {
					sb.append("*");
					i = 2 * i - 1;
				} else {
					sb.append(s1.charAt(i));
				}
			} else {
				sb.append(s1.charAt(i));
			}
			count++;
			i++;
		}

		System.out.println("Encoded String: " + sb.toString() + " with length of: " + count);
	}

}
