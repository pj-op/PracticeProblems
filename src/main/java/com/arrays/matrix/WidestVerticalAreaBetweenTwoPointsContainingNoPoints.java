package com.arrays.matrix;

import java.util.Arrays;
import java.util.Comparator;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public static void main(String[] args) {
        int[][] points = {{8, 7}, {9, 9}, {7, 4}, {9, 7}};
        System.out.println(maxWidthOfVerticalAreaSlightOptimal(points));
    }

    private static int maxWidthOfVerticalAreaSlightOptimal(int[][] points) {
        int i = 0;
        int ans = Integer.MIN_VALUE;
        int[] arr = new int[points.length];
        for (int[] a : points) arr[i++] = a[0];
        Arrays.sort(arr);
        for (int j = 1; j < arr.length; j++) {
            ans = Math.max(ans, arr[j] - arr[j - 1]);
        }
        return ans;
    }

    public static int maxWidthOfVerticalArea(int[][] points) {
        int ans = Integer.MIN_VALUE;

        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i < points.length; i++) {
            ans = Math.max(ans, points[i][0] - points[i - 1][0]);
        }
        return ans;
    }
}
