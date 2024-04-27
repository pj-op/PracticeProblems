package com.arrays;

public class CountLengthOfCycle {

	public static void main(String args[]) {
		int arr[] = { 1, 0 };
		int startIndex = 0;
		System.out.println(countLengthofcycle(arr, startIndex));
	}

	public static int countLengthofcycle(int[] arr, int startIndex) {

		int res[] = new int[arr.length];
		int count = 0;
		int index = startIndex;

		while (res[index] == 0) {
			res[index] = ++count;
			index = arr[index];
		}

		return count - res[index] + 1;
	}
}
