package com.maths;

import java.util.stream.IntStream;

public class PrintPrimeNumbers {

	public static void main(String[] args) {

		IntStream.rangeClosed(2, 1999).filter(x -> IntStream.rangeClosed(2, x / 2).noneMatch(y -> x % y == 0))
				.forEach(System.out::println);

	}

}
