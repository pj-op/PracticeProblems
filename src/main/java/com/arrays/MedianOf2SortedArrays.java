package com.arrays;

public class MedianOf2SortedArrays {

    public static void main(String[] args) {
//		int numArray1[] = { 1, 5, 8, 10, 18, 20 };
//		int numArray2[] = { 2, 3, 6, 7 };
        int numArray1[] = {1, 2, 5};
        int numArray2[] = {3, 4};

        System.out.println(getMedian(numArray1, numArray2));

    }

//	l1<r2
//	l2<r1

    public static double getMedian(int n1[], int n2[]) {

        int low = 0;
        int high = Math.max(n1.length, n2.length);

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n1.length + n2.length) / 2 - cut1;

            double l1 = cut1 == 0 ? Integer.MIN_VALUE : n1[cut1 - 1];
            double l2 = cut2 == 0 ? Integer.MIN_VALUE : n2[cut2 - 1];
            double r1 = cut1 == n1.length ? Integer.MAX_VALUE : n1[cut1];
            double r2 = cut2 == n2.length ? Integer.MAX_VALUE : n2[cut2];

            if (l1 > r2)
            {
                high = cut1 - 1;
            }
            else if (l2 > r1)
            {
                low = cut1 + 1;
            }
            else
            {
//				System.out.println((Math.max(l1, l2) + Math.min(r1, r2)));
                double median = (n1.length + n2.length) % 2 == 0 ? (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0 : Math.min(r1, r2);
                return median;
            }

        }

        return 0.0;
    }
}
