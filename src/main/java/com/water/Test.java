package com.water;

/*Write a function that transforms string into a new string. New string does not contain repeating letters but contains a number after every 
 * letter that means how many times the letter was repeated in the original string

"" -> ""

"aab" -> "a2b1"

"aaaabbbaab" -> "a4b3a2b1"
  
    
 Given a non-empty string, you may delete at most one character. Judge whether you can make it a palindrome



"aaccaa" -> true

"aadccaa" -> true

"aadccbaa" -> false



public boolean isPalindromic(String input) {

}   

*/

public class Test {

	public static void main(String[] args) {

		String inputString = "aaccaa";

		System.out.println(isPalindromic(inputString));
	}

	public static boolean isPalindromic(String input) {

		int i = 0;
		int j = input.length() - 1;
		char[] charArr = input.toCharArray();

		for (char c : charArr) {
			if (input.charAt(i) == input.charAt(j)) {
				i++;
				j--;
			} else {
				return false;
			}

		}
		return true;
	}

}
