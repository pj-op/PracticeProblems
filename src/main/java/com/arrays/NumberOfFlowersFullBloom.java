package com.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NumberOfFlowersFullBloom {
    public static void main(String[] args) {
        int[][] flowers =
//                {{1, 10}, {3, 3}};
        {{1, 6}, {3, 7}, {9, 12}, {4, 13}};
        int[] people =
//                {3, 3, 2};
        {2, 3, 7, 11};
        System.out.println(Arrays.toString(fullBloomFlowersOptimal(flowers, people)));
    }

    private static int[] fullBloomFlowersOptimal(int[][] flowers, int[] people) {
        int n = flowers.length;
        int people_length = people.length;
        int[] ans = new int[people_length];
        int[] upperBound = new int[n];
        int[] lowerBound = new int[n];

        IntStream.range(0, n).forEach(i -> {
            lowerBound[i] = flowers[i][0];
            upperBound[i] = flowers[i][1];
        });
        Arrays.sort(upperBound);
        Arrays.sort(lowerBound);
        for (int i = 0; i < people_length; i++) {
            int upBound = bisectRight(lowerBound, people[i]);
            int lowBound = bisectLeft(upperBound, people[i]);
            ans[i] = upBound - lowBound;
        }
        return ans;
    }

    public static int bisectRight(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) left = mid + 1;
             else right = mid;
        }
        return left;
    }

    public static int bisectLeft(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int people_length = people.length;
        int[] res = new int[people_length];
        for (int i = 0; i < people_length; i++) {
            int count = 0;
            for (int j = 0; j < flowers.length; j++) {
                if (people[i] >= flowers[j][0] && people[i] <= flowers[j][1]) {
                    res[i] = ++count;
                }
            }
        }
        return res;
    }
}
