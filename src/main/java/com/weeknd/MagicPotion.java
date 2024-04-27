package com.weeknd;

public class MagicPotion {

	public static void main(String[] args) {
		System.out.println(
					generateMagicPotion("ABABCABABCD").equals("AB*C*D")
				&& generateMagicPotion("ABCABCE").equals("ABC*E")
				&& generateMagicPotion("AAAE").equals("A*AE")
		);
	}

	public static String generateMagicPotion(String str) {

		int i = 1;
		StringBuilder sb = new StringBuilder();
		sb.append(str.charAt(0));
		while (i < str.length()) {
			if (str.length() > 2 * i) {
				if (str.substring(0, i).equals(str.substring(i, 2 * i))) {
					sb.append("*");
					i = 2 * i - 1;
				} else {
					sb.append(str.charAt(i));
				}
			} else {
				sb.append(str.charAt(i));
			}
			i++;

		}

		return sb.toString();
	}
}
