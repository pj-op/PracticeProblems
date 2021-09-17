package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tri {
    public static void main(String[] args) {
        List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3));
//        System.out.println(findMinimumPathSumII(triangle));

//        Best Time to Buy and Sell Stock
        int stocks[] = {7, 6, 4, 3, 1};
//        System.out.println(maxProfit(stocks));

//        Spriarl Matrix
        int matrix[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}, {21, 22, 23, 24}, {25, 26, 27, 28}, {29, 30, 31, 32}, {33, 34, 35, 36}};
//        System.out.println(spiralMatrixII(matrix));

    }

    private static int findMinimumPathSumII(List<List<Integer>> triangle) {
        int sum = 0;
        int dp[][] = new int[triangle.size()][triangle.size()];
        List<Integer> lastRow = triangle.get(triangle.size() - 1);

        for (int i = 0; i < lastRow.size(); i++) {
            dp[dp.length - 1][i] = lastRow.get(i);
        }
//        System.out.println(Arrays.deepToString(dp));

        for (int i = dp.length - 2; i > -1; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                int currLeft = dp[i + 1][j];
                int currRight = dp[i + 1][j + 1];
                int currValue = row.get(j);
                sum = currValue + Math.min(currLeft, currRight);
                dp[i][j] = sum;
            }
        }

        System.out.println(Arrays.deepToString(dp));


        return dp[0][0];
    }

    private static List<Integer> spiralMatrixII(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int minRow = 0, maxRow = matrix.length - 1, minCol = 0, maxCol = matrix[0].length - 1;
        int index = 0, length = matrix.length * matrix[0].length;

        while (index < length) {
            for (int i = minCol; i <= maxCol && index < length; i++) {
                result.add(matrix[minRow][i]);
                index++;
            }
            minRow++;
            for (int i = minRow; i <= maxRow && index < length; i++) {
                result.add(matrix[i][maxCol]);
                index++;
            }
            maxCol--;
            for (int i = maxCol; i >= minCol && index < length; i--) {
                result.add(matrix[maxRow][i]);
                index++;
            }
            maxRow--;
            for (int i = maxRow; i >= minRow && index < length; i--) {
                result.add(matrix[i][minCol]);
                index++;
            }
            minCol++;
        }

        System.out.println(result);

        return result;
    }

    private static int maxProfit(int[] stocks) {
        int currMin = Integer.MAX_VALUE;
        int profit = 0, maxProfit = Integer.MIN_VALUE;
        int i = 0;
        int j = i + 1;

        while (i < stocks.length && j < stocks.length) {
            currMin = Math.min(currMin, stocks[i]);
            if (stocks[j] > currMin) {
                profit = stocks[j] - currMin;
                maxProfit = Math.max(maxProfit, profit);
            }
            i++;
            j++;
        }

        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
    }


}
