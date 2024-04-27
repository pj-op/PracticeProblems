package com.againpractice;

public class StudentElectionProgram {

	public static void main(String[] args) {
		System.out.println(findSurvivedPerson(4, 2));
	}

	public static int findSurvivedPerson(int n, int k) {

		if (n == 1) {
			return 0;
		}
		return (findSurvivedPerson(n - 1, k) + k) % n;
	}

}
