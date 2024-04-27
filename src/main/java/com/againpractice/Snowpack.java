package com.againpractice;

public class Snowpack {

	public static void main(String[] args) {

		int arr[] = { 0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0 };

//		getUnitOfCollectedSnow(arr);
		getUnitsWithOptimalWay(arr);
	}

	private static void getUnitOfCollectedSnow(int[] arr) {

		if (arr == null || arr.length == 0)
			return;

		int left[] = new int[arr.length];
		int right[] = new int[arr.length];

		left[0] = arr[0];

		for (int i = 1; i < arr.length; i++) {
			left[i] = Math.max(left[i - 1], arr[i]);
		}

		right[arr.length - 1] = arr[arr.length - 1];

		for (int i = arr.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], arr[i]);
		}

		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result = result + Math.min(left[i], right[i]) - arr[i];
		}

//		Arrays.stream(right).forEach(System.out::print);
		System.out.println(result);
	}

	private static void getUnitsWithOptimalWay(int[] arr) {

		if (arr == null || arr.length == 0)
			return;

		int left = 0;
		int right = arr.length - 1;
		int waterUnit = 0;

		int maxLeft = arr[left];
		int maxRight = arr[right];

		while (left < right) {
			if (arr[left] <= arr[right]) {
				maxLeft = Math.max(maxLeft, arr[left]);
				waterUnit = waterUnit + maxLeft - arr[left];
				left++;
			} else if (arr[left] >= arr[right]) {
				maxRight = Math.max(maxRight, arr[right]);
				waterUnit = waterUnit + maxRight - arr[right];
				right--;
			}
		}

		System.out.println(waterUnit);
	}

}
