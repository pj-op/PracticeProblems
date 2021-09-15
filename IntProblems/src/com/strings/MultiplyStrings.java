package com.strings;

import java.util.Scanner;

public class MultiplyStrings {

	static Scanner scanner = null;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		String s1 = scanner.next();
		String s2 = scanner.next();

		System.out.println(mul(s1, s2));
	}

	public static String mul(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();

		int result[] = new int[l1 + l2];
		int i = l1 - 1;
		int pf = 0;

		while (i >= 0) {
			int iVal = s1.charAt(i) - '0';
			i--;

			int j = l2 - 1;
			int carry = 0;
			int k = result.length - 1 - pf;

			while (j >= 0 || carry != 0) {
				int jVal = j >= 0 ? s2.charAt(j) - '0' : 0;
				j--;

				int prod = iVal * jVal + carry + result[k];
				carry = prod / 10;
				result[k] = prod % 10;
				k--;
			}
			pf++;
		}

		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		sb.append("");

		for (int a : result) {
			if (a == 0 && flag == false) {
				continue;
			} else {
				flag = true;
				sb = sb.append(a);
			}
		}
		return sb.toString();
	}
}