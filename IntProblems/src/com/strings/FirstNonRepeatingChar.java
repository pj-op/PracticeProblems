package com.strings;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {

		String str = "dddccdbbaadr";

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

}
