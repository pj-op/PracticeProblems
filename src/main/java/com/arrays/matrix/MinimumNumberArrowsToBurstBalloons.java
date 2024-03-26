package com.arrays.matrix;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] points =
//                {{10, 16}, {2, 8}, {1, 6}, {7, 12}}
//                {{1, 2}, {3, 4}, {5, 6}, {7, 8}}
//                {{1, 2}, {2, 3}, {3, 4}, {4, 5}}
                {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
                ;
        System.out.println(findMinArrowShots(points));
    }

    private static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        System.out.println(Arrays.deepToString(points));

        int totalBallons = points.length;

        boolean[] isBurst = new boolean[totalBallons];
        int count = 0;
        for (int i = 0; i < totalBallons; i++) {
            if (i + 1 < totalBallons && (points[i + 1][0] <= points[i][1])) {
                if (!isBurst[i] && !isBurst[i + 1]) {
                    isBurst[i] = true;
                    isBurst[i + 1] = true;
                    count++;
                }
            } else if (!isBurst[i]) {
                isBurst[i] = true;
                count++;
            }
        }

        return count;
    }
}
