package com.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// 5. Group Anagrams

public class GroupAnagrams {

	public static void main(String args[]) {

		List<String> inputList = Arrays.asList("cat", "dog", "god");

		System.out.println(getGroupAnagrams(inputList));

	}

	private static Map getGroupAnagrams(List<String> inputList) {

		Map<String, Set<String>> dataMap = new HashMap<>();

		for (String input : inputList) {
			String hash = getStringInSortedForm(input);

			if (dataMap.containsKey(hash)) {
				dataMap.get(hash).add(input);
			} else {
				Set<String> sWord = new HashSet<>();
				sWord.add(input);
				dataMap.put(hash, sWord);
			}

		}

		return dataMap;
	}

	private static String getStringInSortedForm(String word) {
		char[] charArray = word.toCharArray();
		Arrays.sort(charArray);
		return String.valueOf(charArray);
	}
}
