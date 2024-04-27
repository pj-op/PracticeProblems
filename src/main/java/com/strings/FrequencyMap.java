package com.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencyMap {

	static Scanner scan = null;

	public static void main(String[] args) {
		scan = new Scanner(System.in);

		String str = scan.next();

		System.out.println(freqMap(str));
	}

	public static Map<Character, Integer> freqMap(String s1) {

		Map<Character, Integer> dataMap = new HashMap<>();

		for (Character a : s1.toCharArray()) {
			if (dataMap.containsKey(a)) {
				dataMap.put(a, dataMap.get(a) + 1);
			} else {
				dataMap.put(a, 1);
			}
		}

		return dataMap;
	}

}
