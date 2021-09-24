package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Array2d {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        System.out.println(Arrays.toString(printSpiralMatrix(matrix)));

        int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
//        System.out.println(findMinPathSum(triangle));

        String[][] inputTests = {{"rabbbit", "rabbit"}, {"bgbabag", "bag"}, {"adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", "bcddceeeebecbc"}};

        for (int i = 0; i < inputTests.length; i++) {
//            System.out.println(numDistinct(inputTests[i][0], inputTests[i][1]));
        }
        /*String s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc",
                t = "bcddceeeebecbc";*/
//        System.out.println(findDistinctSubSequence(s, t, 0, 0));
//        System.out.println(numDistinct(s, t));

//        Maximum Numbers of balloons
        String str = "loonbalxballpoon";
        String target = "balloon";
//        System.out.println(countNoOfBalloons(str, target));

//        Final Value of Variable After Performing Operations
        String operations[] = {"X++", "++X", "--X", "X--"};
        System.out.println(valueAfterOperations(operations));

    }

    private static int valueAfterOperations(String[] operations) {
        int x = 0;

        for (String s : operations) {
            if(s.contains("+"))x++;
            else x--;
        }
        return x;
    }


    private static int countNoOfBalloons(String str, String target) {

        Map<Character, Integer> targetStr = new HashMap<>();
        Map<Character, Integer> strMap = new HashMap<>();
        int count = 0;

        for (char c : target.toCharArray()) {
            targetStr.put(c, targetStr.getOrDefault(c, 0) + 1);
        }

        for (char s : str.toCharArray()) {
            strMap.put(s, strMap.getOrDefault(s, 0) + 1);
        }

        /*for (Map.Entry<Character, Integer> map : strMap.entrySet()) {
            if (targetStr.containsKey(map.getKey())) {
                System.out.println(map.getKey() + "  " + map.getValue());
            }
        }*/
        StringBuilder sb = new StringBuilder();

        for (char t : target.toCharArray()) {
            if (strMap.containsKey(t)) {
                strMap.get(t);
                sb = sb.append(t);
            }
        }

        System.out.println(sb.toString());

        return 0;
    }

    private static int findDistinctSubSequence(String s, String t, int i, int j) {
        int dp[][] = new int[s.length() + 1][t.length() + 1];
        int count = 0;
        if (dp[i][j] != 0) return dp[i][j];
        if (j == t.length()) {
            count++;
            return count;
        }
        if (i == s.length()) {
            return 0;
        }

        if (s.charAt(i) != t.charAt(j)) return dp[i][j] = findDistinctSubSequence(s, t, i + 1, j);
        else return dp[i][j] = findDistinctSubSequence(s, t, i + 1, j + 1) + findDistinctSubSequence(s, t, i + 1, j);

    }

    public static int numDistinct(String S, String T) {
        // array creation
        int[][] mem = new int[T.length() + 1][S.length() + 1];

        // filling the first row: with 1s
        for (int j = 0; j <= S.length(); j++) {
            mem[0][j] = 1;
        }

        // the first column is 0 by default in every other rows but the first, which we need.

        for (int i = 0; i < T.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (T.charAt(i) == S.charAt(j)) {
                    mem[i + 1][j + 1] = mem[i][j] + mem[i + 1][j];
                } else {
                    mem[i + 1][j + 1] = mem[i + 1][j];
                }
            }
        }

        System.out.println(Arrays.deepToString(mem));

        return mem[T.length()][S.length()];
    }

    private static int findMinPathSum(int[][] triangle) {
        int dp[][] = new int[triangle.length][triangle.length];
        int sum = 0;

        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            dp[dp.length - 1][i] = triangle[triangle.length - 1][i];
        }

        for (int i = triangle.length - 2; i > -1; i--) {
            int[] curArray = triangle[i];
            for (int j = 0; j < curArray.length; j++) {
                int curLeft = dp[i + 1][j];
                int curRight = dp[i + 1][j + 1];
                int currValue = curArray[j];
                sum = currValue + Math.min(curLeft, curRight);
                dp[i][j] = sum;
            }
        }
        System.out.println(Arrays.deepToString(dp));

        return dp[0][0];
    }

    private static int[] printSpiralMatrix(int[][] matrix) {
        int result[] = new int[matrix.length * matrix[0].length];
        int minRow = 0, minCol = 0, maxRow = matrix.length - 1, maxCol = matrix[0].length - 1;
        int index = 0;
        while (index < result.length) {
            for (int i = minCol; i <= maxCol && index < result.length; i++) {
                result[index] = matrix[minRow][i];
                index++;
            }
            minRow++;
            for (int i = minRow; i <= maxRow && index < result.length; i++) {
                result[index] = matrix[i][maxCol];
                index++;
            }
            maxCol--;
            for (int i = maxCol; i >= minCol && index < result.length; i--) {
                result[index] = matrix[maxRow][i];
                index++;
            }
            maxRow--;
            for (int i = maxRow; i >= minRow && index < result.length; i--) {
                result[index] = matrix[i][minCol];
                index++;
            }
            minCol++;

        }
        return result;
    }
}
