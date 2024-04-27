package com.strings;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {

		String str = "dddccdbbaadr";
		optimalWay(str);

		LinkedHashMap<Character, Integer> dataMap = new LinkedHashMap<>();

		for (char a : str.toLowerCase().toCharArray()) {
			if (dataMap.containsKey(a)) {
				dataMap.put(a, dataMap.get(a) + 1);
			} else {
				dataMap.put(a, 1);
			}
		}
		System.out.println(dataMap);

		for (Entry<Character, Integer> s : dataMap.entrySet()) {
			if (s.getValue() == 1) {
				System.out.println(s.getKey() + " - " + str.indexOf(s.getKey()));
				break;
			}
		}
	}

	private static void optimalWay(String str) {

		int[] alpabets = new int[26];

		for (char c : str.toCharArray()) {
			alpabets[c - 'a']++;
		}

		for (char c1 : str.toCharArray()) {
			if (alpabets[c1 - 'a'] == 1) {
				System.out.println(c1);
				break;
			}
		}
		System.out.println(Arrays.toString(alpabets));

	}

}
