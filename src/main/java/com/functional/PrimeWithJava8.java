package com.functional;

import java.util.stream.IntStream;

public class PrimeWithJava8 {

	public static void main(String[] args) {

		IntStream.rangeClosed(2, 999)
				.filter(x -> IntStream.rangeClosed(2, (int) Math.sqrt(x)).noneMatch(s -> x % s == 0))
				.forEach(System.out::println);

	}

}
