package com.arrays.matrix;

public class CountPalindromicSubStrings {
    public static void main(String[] args) {
        String s = "abbac";
        System.out.println(countPalindromicSubStringUsingDP(s));
        System.out.println(countPalindromicSubStringOptimal(s));
    }

    private static int countPalindromicSubStringOptimal(String str) {
        int count = 0;
        int n = str.length();
        char[] chars = str.toCharArray();
        for (int i = 0; i < n; i++) {
            int leftPointer = i, rightPointer = i;
            while (leftPointer >= 0 && rightPointer < n && chars[leftPointer] == chars[rightPointer]) {
                System.out.println(str.substring(leftPointer, rightPointer + 1));
                count++;
                leftPointer--;
                rightPointer++;
            }
            leftPointer = i;
            rightPointer = i + 1;
            while (leftPointer >= 0 && rightPointer < n && chars[leftPointer] == chars[rightPointer]) {
                System.out.println(str.substring(leftPointer, rightPointer + 1));
                count++;
                leftPointer--;
                rightPointer++;
            }
        }
        return count;
    }

    private static int countPalindromicSubStringUsingDP(String str) {
        int count = 0;
        boolean[][] dp = new boolean[str.length()][str.length()];
        int n = dp.length;

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < dp.length; i++, j++) {
                if (gap == 0) dp[i][j] = true;
                else {
                    var first_and_last_char_equal = str.charAt(i) == str.charAt(j);
                    if (gap == 1) {
                        dp[i][j] = first_and_last_char_equal;
                    } else {
                        dp[i][j] = first_and_last_char_equal && dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) count++;
            }
        }
        return count;
    }

}