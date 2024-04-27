package com.againpractice;

public class MedianOf2SortedArrays {

	public static void main(String[] args) {
		int a1[] = { 1 };
		int a2[] = { 4, 5, 6 };
		System.out.println(findMedianOfSortedArray(a1, a2));
	}

	public static double findMedianOfSortedArray(int a[], int b[]) {

		int n1 = a.length;
		int n2 = b.length;

		int l1, l2, r1, r2;

		int low = 0;
		int high = n1;

		if (n1 > n2)
			return findMedianOfSortedArray(b, a);

		while (low <= high) {

			int cut1 = (low + high) / 2;
			int cut2 = (n1 + n2) / 2 - cut1;

			l1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
			l2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];
			r1 = cut1 == n1 ? Integer.MAX_VALUE : a[cut1];
			r2 = cut2 == n2 ? Integer.MAX_VALUE : b[cut2];

			if (l1 > r2)
				high = cut1 - 1;
			else if (l2 > r1)
				low = cut1 + 1;
			else
				return (n1 + n2) % 2 == 0 ? (Math.max(l1, l2) + Math.min(r1, r2)) / 2d : Math.min(r1, r2);

		}

		return -1;
	}

}