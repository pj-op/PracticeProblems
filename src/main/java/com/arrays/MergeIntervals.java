package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{2, 6}, {1, 3}, {8, 10}, {15, 18}, {17, 22}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        int m = intervals.length;
        List<int[]> temp = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i < m; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i][0] = intervals[i - 1][0];
                intervals[i - 1] = null;
            }
        }

        for (int[] interval : intervals) {
            if (interval != null) {
                temp.add(interval);
            }
        }
        return temp.toArray(new int[temp.size()][]);
    }
}
