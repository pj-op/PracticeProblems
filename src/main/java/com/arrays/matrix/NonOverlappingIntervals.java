package com.arrays.matrix;

//https://leetcode.com/problems/non-overlapping-intervals/

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] test = {
                {1, 2}, {2, 3}, {3, 4}, {1, 3}
        };
        System.out.println(eraseOverlapIntervals(test));

    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        int prevEnd = Integer.MIN_VALUE;
        Arrays.sort(intervals, (o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o1[1] - o2[1]);
        for (int[] interval : intervals) {
            if (prevEnd > interval[0]) result++;
            else prevEnd = interval[1];
        }
        return result;
    }
}
