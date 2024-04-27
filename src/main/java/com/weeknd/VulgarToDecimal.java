package com.weeknd;

import java.util.HashMap;

public class VulgarToDecimal {
	public static void main(String[] args) {
		long num = 18;
		long deno = 7;

		System.out.println(vulgarToDecimal(num, deno));
	}

	public static String vulgarToDecimal(Long numerator, Long denominator) {
		StringBuilder sb = new StringBuilder();
		HashMap<Long, Integer> remMap = new HashMap<>();

		long division = numerator / denominator;
		long rem = numerator % denominator;
		sb.append(division);

		if (rem == 0)
			return sb.toString();
		else
			sb.append(".");

		while (rem != 0) {
			if (remMap.containsKey(rem)) {
				sb.insert(remMap.get(rem), "(");
				sb.append(")");
				break;
			} else {
				remMap.put(rem, sb.length());
				rem = rem * 10;
				sb.append(rem / denominator);
				rem = rem % denominator;
			}
		}
		System.out.println(remMap);

		return sb.toString();

	}

}
