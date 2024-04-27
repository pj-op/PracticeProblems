package com.weeknd;

public class Snowpack {

	public static void main(String[] args) {

		int inputArray[] = { 1, 1, 1, 1, 1, 1, 1, 1, 9 };

		calculateTotalWaterUnits(inputArray);
	}

	private static void calculateTotalWaterUnits(int[] inputArray) {

		if (inputArray == null || inputArray.length == 0)
			return;

		int left = 0;
		int right = inputArray.length - 1;

		int maxLeft = 0;
		int maxRight = 0;
		int totalWater = 0;

		while (left < right) {
			if (inputArray[left] < inputArray[right]) {
				maxLeft = Math.max(maxLeft, inputArray[left]);
				totalWater = totalWater + maxLeft - inputArray[left];
				left++;
			} else {
				maxRight = Math.max(maxRight, inputArray[right]);
				totalWater = totalWater + maxRight - inputArray[right];
				right--;
			}
		}

		System.out.println("Total Water: " + totalWater);

	}
}