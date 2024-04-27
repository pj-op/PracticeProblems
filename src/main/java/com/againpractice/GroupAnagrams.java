package com.againpractice;

import java.util.*;

public class GroupAnagrams {

	public static void main(String[] args) {

		List<String> l = Arrays.asList("cat", "dog", "god");

		System.out.println(grpAnagrams(l));
	}

	public static Collection<Set<String>> grpAnagrams(List<String> strArray) {
		HashMap<String, Set<String>> dataMap = new HashMap<>();

		if (strArray == null || strArray.size() == 0)
			return new HashSet<Set<String>>();

		for (String s : strArray) {
			String checkString = getSortedString(s);

			if (dataMap.containsKey(checkString) && checkString.equals(getSortedString(s))) {
//				System.out.print("here");
				Set<String> anagrams = dataMap.get(getSortedString(s));
				anagrams.add(s);
//				System.out.print(anagrams);
				dataMap.put(checkString, anagrams);
			} else {
				Set<String> l = new HashSet<>();
				l.add(s);
//				System.out.print(l);
				String s2 = getSortedString(s);
				dataMap.put(s2, l);
			}

		}
		List<List<String>> ans = new ArrayList<>();
//        ans.addAll((Collection<? extends List<String>>) dataMap.values());

//		System.out.println(dataMap);
		return dataMap.values();
	}

	public static String getSortedString(String s1) {
		char[] charArray = s1.toCharArray();
		Arrays.sort(charArray);
		return String.valueOf(charArray);
	}
}
