package com.strings;

import java.util.Scanner;

public class MulString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter String 1: ");
		String s1 = scan.next();
		System.out.println("Enter String 2: ");
		String s2 = scan.next();

		System.out.println(s1 + " x " + s2 + " = " + getMulResult(s1, s2));
		scan.close();
	}

	public static String getMulResult(String s1, String s2) {

		int l1 = s1.length();
		int l2 = s2.length();

		if (s1.equals("0") || s2.equals("0")) {
			return "0";
		}

		int result[] = new int[l1 + l2];

		int i = l1 - 1;
		int pf = 0;

		while (i >= 0) {
			int iVal = s1.charAt(i) - '0';
			i--;

			int j = l2 - 1;
			int k = result.length - 1 - pf;
			int carry = 0;

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
