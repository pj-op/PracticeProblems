package com.strings;

public class ReverseStringWithoutReplacingSpecialChars {

	public static void main(String[] args) {

		String k = "^t&&u*as%";
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
		System.out.println(String.valueOf(s));

//		for (int i = 0; i <= 256; i++) {
//			System.out.println(i + "==>" + (char) (i));
//		}

	}

}
