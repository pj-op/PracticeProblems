package com.arrays;

public class MinimumTimeVisitingAllPoints {
    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(minTimeToVisitAllPoints(points));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;

        for (int i = 1; i < points.length; i++) {

            int[] arr1 = points[i];
            int[] arr2 = points[i - 1];

            int x1 = arr2[0];
            int y1 = arr2[1];
            int x2 = arr1[0];
            int y2 = arr1[1];

            double dist = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
            System.out.println(dist + " -- " + ans);
            ans += (int) dist;
        }
        return ans;
    }
}
