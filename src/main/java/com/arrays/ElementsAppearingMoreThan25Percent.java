package com.arrays;

public class ElementsAppearingMoreThan25Percent {
    public static void main(String[] args) {
        int[] arr = {6700, 8858, 8858, 8858, 8858};
        System.out.println(findSpecialInteger(arr));
    }

    public static int findSpecialInteger(int[] arr) {
        int n = arr.length;

        if (n == 1) return arr[0];

        int threshold = n / 4;
        int[] freqArr = new int[arr[n - 1] - arr[0] + 1];

        for (int ele : arr) {
            freqArr[ele - arr[0]]++;
        }

        for (int i = 0; i < freqArr.length; i++) {
            if (freqArr[i] > threshold) {
                return i + arr[0];
            }
        }
        return 0;
    }
}
