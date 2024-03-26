package com.matrixoperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerformMatrixOperations {
    public static void main(String[] args) {
//        int[][] testCase = new int[4][4];
//        makeDiagonal_1(testCase);

        String s = "abbcbb";
        longestPalindromicSubsequence(s);

        /*int[][][] array = {{{1, 2, 3, 4}, {5, 6, 7, 8}}, {{11, 12, 13, 14, 15}}};
        List<List<List<Integer>>> listArray =
                //First Way
                //Arrays.stream(array).map(i -> Arrays.stream(i).map(j -> Arrays.stream(j).boxed().collect(Collectors.toList())).collect(Collectors.toList())).toList();
                //Second way
                IntStream.range(0, array.length)
                        .mapToObj(i -> IntStream.range(0, array[i].length)
                                .mapToObj(j -> IntStream.range(0, array[i][j].length)
                                        .mapToObj(k -> array[i][j][k]).collect(Collectors.toList())).collect(Collectors.toList())).collect(Collectors.toList());


        String flattenedList = listArray.stream().flatMap(List::stream).flatMap(List::stream).map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(flattenedList);
        System.out.println(listArray);*/
    }

    private static void longestPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                System.out.println("J Value: " + j);
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));

        /*[[1, 1, 0, 0],
        [0, 1, 2, 0],
        [0, 0, 1, 1],
        [0, 0, 0, 1]
        ]*/
    }

    private static void makeDiagonal_1(int[][] testCase) {

        for (int i = 0; i < testCase.length; i++) {
            for (int j = 0; j < testCase[0].length; j++) {
                if (i == j) {
                    testCase[i][j] = 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(testCase));
    }
}
