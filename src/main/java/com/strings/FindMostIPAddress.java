package com.strings;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

		final int max = 1;
		List<String> ipS = new ArrayList<>();

//		for (Entry<String, Integer> s : dataMap.entrySet()) {
//			if (s.getValue() > max) {
//				max = s.getValue();
//			}
//		}
//
//		for (Entry<String, Integer> s : dataMap.entrySet()) {
//			if (s.getValue() == max) {
//				ipS.add(s.getKey());
//			}
//		}

//		System.out.println(max);

		dataMap.forEach((k, v) -> {
			if (v > max) {
				ipS.add(k);
			}
		});
		System.out.println(ipS);
	}

}
