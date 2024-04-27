package com.againpractice;

public class ReverseStringWithBug {
	public static void main(String[] args) {
		String str = "^tu&as%";
		reverseStringWithBug(str);
	}

	private static void reverseStringWithBug(String str) {
		// TODO Auto-generated method stub
		char charArray[] = str.toCharArray();
		int j = str.length() - 1;
		int i = 0;

		while (i <= j) {
			if (!Character.isAlphabetic(charArray[i])) {
				i++;
			} else if (!Character.isAlphabetic(charArray[j])) {
				j--;
			} else {
				char temp = charArray[i];
				charArray[i] = charArray[j];
				charArray[j] = temp;
				i++;
				j--;
			}
		}

//		System.out.print(Arrays.toString(charArray));
		System.out.println(String.valueOf(charArray));
	}

}
