package com.array;

import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3));
        System.out.println(findMinPath(triangle));
    }

    public static Integer findMinPath(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        // init the first row
        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        for (int i = 0; i < lastRow.size(); i++) {
            dp[triangle.size() - 1][i] = lastRow.get(i);
        }

        System.out.println(Arrays.deepToString(dp));

        for (int i = triangle.size() - 2; i > -1; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                int maxSumLeft = dp[i + 1][j];
                int maxSumRight = dp[i + 1][j + 1];
                int currentValue = row.get(j);
                int sumPath = currentValue + Math.min(maxSumLeft, maxSumRight);
                dp[i][j] = sumPath;
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[0][0];
    }
}
