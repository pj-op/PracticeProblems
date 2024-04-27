package com.dp;

public class StudentElectionProgram {
	
	public static void main(String[] args) {
		System.out.println(whoIsElected(4, 2));
	}
	
	public static int whoIsElected(int n, int k) {
		
		if(n == 1) return 1;
		
		int [] arr = new int[n + 1];
		
		for(int i = 1 ;i <= n ;i ++) {
			arr[i] = i;
		}
		
		int secondN = 0;
		int count = 0;
		int index = 1;
		
		while(secondN != n-1) {
			if(arr[index] != 0) {
				count++;
				if(count == k) {
					arr[index] = 0;
					count = 0;
					secondN ++;
				}
			}
			//System.out.println(arr[index] + " " + secondN + " " + 
			//count + " " + index);
			index++; 
			if(index == n+1) index = 1;
		}
		
		return nonZeroIndex(arr);
	}

	private static int nonZeroIndex(int[] arr) {
		
		for(int i = 1 ; i < arr.length ; i ++) {
			if(arr[i] > 0) return arr[i];
		}
		return -1;
	}
}
