package com.strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindMostIPAddress {

	public static void main(String[] args) {

		String[] a = new String[] { "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
				"10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
				"10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234" };

		findTopAddress(a);
	}

	public static void findTopAddress(String[] ar) {

		Map<String, Integer> dataMap = new LinkedHashMap<>();

		for (String x : ar) {

			String a = x.substring(0, 8);

			if (dataMap.containsKey(a)) {
				dataMap.put(a, dataMap.get(a) + 1);
			} else {
				dataMap.put(a, 1);
			}
		}

//		System.out.println(dataMap);

//		dataMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

		int curr = 0;
		int max = 0;

		for (Entry<String, Integer> s : dataMap.entrySet()) {
			curr = s.getValue();
			if (curr > max) {
				max = curr;
			}

			if (s.getValue().equals(2)) {
				System.out.println(s.getKey());
			}
		}

//		return null;
	}

}
