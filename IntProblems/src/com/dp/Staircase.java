package com.dp;

public class Staircase {

	public static void main(String[] args) {
		
		// either 1, 2 or 3 steps at a time
		System.out.println(countSteps(5));
		
	}
	
	public static Integer countSteps(Integer n) {
		
		if(n <= 0) return 0;
		
		if(n <= 2) return n;
		
		if(n == 3) return n+1;
		
		return countSteps(n - 1) + countSteps( n - 2) + countSteps( n - 3);
	}

}
