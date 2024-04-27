package com.weeknd;

import java.util.Arrays;

public class StairCases {

	public static void main(String[] args) {
		int noOfSteps = 30;

		System.out.println(findTotalNumberOfSteps(noOfSteps));
//		System.out.println(findTotalNumberOfStepsWithDP(noOfSteps));
	}

//	Time complexity of this recursive solution will be exponential
	private static int findTotalNumberOfSteps(int n) {

		if (n == 1 || n == 0) {
			return 1;
		} else if (n == 2)
			return 2;
		else
			return findTotalNumberOfSteps(n - 3) + findTotalNumberOfSteps(n - 2) + findTotalNumberOfSteps(n - 1);
	}

//	Solution with DP
	private static int findTotalNumberOfStepsWithDP(int n) {
		int res[] = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		res[2] = 2;

		for (int i = 3; i <= n; i++) {
			res[i] = res[i - 1] + res[i - 2] + res[i - 3];
		}
		
		System.out.println(Arrays.toString(res));
		
		return res[n];
	}
}
