package com.againpractice;

public class MagicPotions {

	public static void main(String[] args) {
		String inputString = "ABABCABABCD";
		getEncodedString(inputString);
	}

	private static void getEncodedString(String inputString) {
		StringBuilder sb = new StringBuilder();
		sb.append(inputString.charAt(0));
		int i = 1;

		while (i < inputString.length()) {
			if (inputString.length() > 2 * i && inputString.charAt(0) == inputString.charAt(i)) {
				if (inputString.substring(0, i).equals(inputString.substring(i, 2 * i))) {
					sb.append("*");
					i = 2 * i - 1;
				} else {
					sb.append(inputString.charAt(i));
				}
			} else {
				sb.append(inputString.charAt(i));
			}
			i++;
		}
		
		System.out.println(sb.toString());

	}

}
