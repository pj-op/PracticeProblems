package com.maths;

import java.util.Scanner;
import java.util.stream.Stream;

public class Fibnocci {

	static StringBuilder sb = null;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the length of the fib series: ");
		int num = scan.nextInt();

		sb = new StringBuilder();

		System.out.println(withForLoop(num));
		printFibWithJava8Stream(num);
		System.out.println();

		for (int i = 0; i < num + 2; i++) {

			System.out.print(printWithRecursion(i) + " ");
		}

		scan.close();
	}

	public static String withForLoop(int serieslength) {
		int a = 0;
		int b = 1;
		int num = 0;
		sb = sb.append("");
		sb.append(a + " ").append(b + " ");

		for (int i = 0; i < serieslength; i++) {
			num = a + b;
			sb.append(num + " ");
			a = b;
			b = num;
		}
		return sb.toString();
	}

	public static void printFibWithJava8Stream(int num) {
		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(num).map(t -> t[0])
				.forEach(x -> System.out.print(x + " "));
	}
	public static int printWithRecursion(int num) {
		if (num <= 1) {
			return num;
		}

		return printWithRecursion(num - 1) + printWithRecursion(num - 2);
	}

}

//1 1 2 3 5 8