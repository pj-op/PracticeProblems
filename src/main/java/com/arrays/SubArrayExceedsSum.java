package com.arrays;

public class SubArrayExceedsSum {

	public static void main(String[] args) {
		int[] a = { 1, 4, 45, 6, 0, 19 };
		int num = 55;

		System.out.println(subArrayExceedsSum(a, num));
	}

	public static int subArrayExceedsSum(int arr[], int target) {

		int subArray[] = new int[arr.length];
		int num = 0;

		for (int i = 0; i < arr.length; i++) {
			System.out.println(target + " = " + target + " - " + arr[i]);
			target = target - arr[i];
			if (target == 0) {
				System.out.println("SubArrayExceedsSum.subArrayExceedsSum()");
				return i;
			}
		}

		return -1;
	}

}
