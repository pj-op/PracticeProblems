package com.arrays;

import java.util.Arrays;

public class FindTheTownJudge {
    public static void main(String[] args) {
        int n = 4;
        int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        System.out.println(findJudge(n, trust));
    }

    private static int findJudge(int n, int[][] trust) {
        int[] count = new int[n];

        for (int[] ints : trust) {
            count[ints[0] - 1] -= 1;
            count[ints[1] - 1] += 1;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] >= n - 1) return i + 1;
        }

        return -1;
    }
}
