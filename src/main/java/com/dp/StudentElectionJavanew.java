package com.dp;

public class StudentElectionJavanew {

	static int josephus(int n, int k) {
		if (n == 1)
			return 1;
		else
			/*
			 * The position returned by josephus(n - 1, k) is adjusted because the recursive
			 * call josephus(n - 1, k) considers the original position k%n + 1 as position 1
			 */
			return (josephus(n - 1, k) + k - 1) % n + 1;
	}

//	static int withBitWise(int n) {
//		return ~Integer.highestOneBit(n*2) & ((n<<1) | 1);
//	}

	// Driver Program to test above function
	public static void main(String[] args) {
		int n = 41;
		int k = 6;
		System.out.println("The chosen place is " + josephus(n, k));
	}
}
