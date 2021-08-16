package com.water;

import java.util.Arrays;

public class RainWaterTrap {

	public static void main(String[] args) {

		int a[] = { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 };

		int ans = 0;
		int l = a.length;
		int left[] = new int[l];
		int right[] = new int[l];

		left[0] = a[0];

		for (int i = 1; i < a.length; i++) {
			left[i] = Math.max(left[i - 1], a[i]);
		}

		right[l - 1] = a[l - 1];
		for (int i = a.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], a[i]);
		}

		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));

		for (int i = 0; i < a.length; i++) {
			ans += Math.min(left[i], right[i]) - a[i];
		}

		System.out.println("Ans is: " + ans);
	}

}
