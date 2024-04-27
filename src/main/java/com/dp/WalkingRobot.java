package com.dp;

public class WalkingRobot {

	public static void main(String[] args) {
		
		
		Integer [] ans = walk("D");
		
		System.out.println("[ " + ans[0] + " , " + ans[1] + " ]" );
		
	}
	public static Integer[] walk(String path) {
		
		char [] input  = path.toCharArray();
		Integer[] ans = new Integer[2];
		ans [0] = 0;
		ans [1] = 0;		
		for(int i = 0 ; i < input.length ; i ++) {
			if(input[i] == 'U') ans[1] += 1;
			else if(input[i] == 'D') ans[1] -= 1;
			else if(input[i] == 'R') ans[0] += 1;
			else if(input[i] == 'L') ans[0] -= 1;
		}
		return ans;
	 }
}
