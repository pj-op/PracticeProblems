package com.againpractice;

import java.util.HashMap;

public class VulgarToDecimal {

	public static void main(String[] args) {
		long a = 22;
		long b = 7;

		vulgarToDecimal(a, b);
	}

	public static void vulgarToDecimal(Long numerator, Long denominator) {

		StringBuilder sb = new StringBuilder();
		sb.append("");

		long div = numerator / denominator;
		long rem = numerator % denominator;

		if (rem == 0) {
			sb.append(div);
			System.out.print(sb.toString());
		}

		sb.append(div);
		sb.append(".");

		HashMap<Long, Integer> numMap = new HashMap<>();

		while (rem != 0) {
			if (numMap.containsKey(rem)) {
				sb.insert(numMap.get(rem), "(");
				sb.append(")");
				break;
			} else {
				numMap.put(rem, sb.length());
				rem = rem * 10;
				sb.append(rem / denominator);
				rem = rem % denominator;
			}

		}
		System.out.println(numMap);
		System.out.println(sb.toString());

	}

}
