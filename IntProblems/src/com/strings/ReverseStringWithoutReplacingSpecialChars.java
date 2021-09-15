package com.strings;

import java.util.Arrays;

public class ReverseStringWithoutReplacingSpecialChars {

	public static void main(String[] args) {

		String k = "/gH?yZx";
		char s[] = k.toCharArray();
		int l = s.length;
		int leftPtr = 0;
		int rightPtr = l - 1;
		char temp;

		while (leftPtr < rightPtr) {

			if (!Character.isAlphabetic(s[leftPtr])) {
				leftPtr++;
			} else if (!Character.isAlphabetic(s[rightPtr])) {
				rightPtr--;
			} else {
				temp = s[leftPtr];
				s[leftPtr] = s[rightPtr];
				s[rightPtr] = temp;
				leftPtr++;
				rightPtr--;
			}

		}
		System.out.println(Arrays.toString(s));
		System.out.println(s.toString());

	}

}
