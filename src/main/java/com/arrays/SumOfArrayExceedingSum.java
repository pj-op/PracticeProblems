package com.arrays;

public class SumOfArrayExceedingSum {

	public static void main(String[] args) {

		int num[] = { 2, 3, 4, 3, 1, 2 };
		int target = 88;
		int sum = 0;
		int result = Integer.MAX_VALUE;
		int left = 0;

		for (int i = 0; i < num.length; i++) {
			sum = sum + num[i];
			while (sum >= target) {
				result = Math.min(result, i + 1 - left);
//				System.out.println("i: " + i + " left: " + left);
				sum = sum - num[left];
				left++;
			}
		}

		System.out.println(result < Integer.MAX_VALUE ? result : -1);
	}

}
