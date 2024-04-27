package com.weeknd;

import java.util.Arrays;

public class LengthOfCycle {

	public static void main(String[] args) {
		int array[] = { 1, 0 };
		System.out.println(countLengthofcycle(array, 0));
	}

	public static int countLengthofcycle(int[] arr, int startIndex) {
		int len = 0;
		int result[] = new int[arr.length];
		int index = startIndex;

		if (startIndex < 0 || startIndex >= arr.length) {
			return -1;
		}

		while (result[index] == 0) {
			result[index] = ++len;
			index = arr[index];
			if (index >= arr.length) {
				return -1;
			}
		}
		System.out.println("Length: " + len);
		System.out.println(Arrays.toString(result));

		return len - result[startIndex] + 1;
	}

}
