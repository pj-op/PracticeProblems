package com.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestWord {

	public static void main(String[] args) {
		String doc[] = new String[] { "toe", "oe", "toes", "doe", "dog", "god", "dogs", "book", "banana", "to", "oe" };
		System.out.println(longestWord("otedg", doc));
	}

	private static Set<String> longestWord(String letters, String[] dictionary) {

		int maxLen = 0;
		Set<String> result = new HashSet<String>();
		for (String word : dictionary) {
			if (maxLen < word.length()) {
				if (getCharSet(letters).containsAll(getCharSet(word))) {
					result.clear();
					System.out.print("IF: " + word + " ===>");
					result.add(word);
					maxLen = word.length();
				}
			} else if (maxLen == word.length()) {
				if (getCharSet(letters).containsAll(getCharSet(word))) {
					result.add(word);
					System.out.print("Else if: " + word + "--> ");
				}
			}

		}

		return result;
	}

	private static Set<Character> getCharSet(String word) {
		Set<Character> charSet = new HashSet<Character>();

		for (int i = 0; i < word.length(); i++) {
			charSet.add(word.charAt(i));
		}
		return charSet;

	}
}
