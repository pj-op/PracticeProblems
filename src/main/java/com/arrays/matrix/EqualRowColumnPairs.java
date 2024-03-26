package com.arrays.matrix;

import java.util.Arrays;

public class EqualRowColumnPairs {
    public static void main(String[] args) {
        int[][] grid = {
               /* {3, 2, 1},
                {1, 7, 6},
                {2, 7, 7}*/

                {3, 1, 2, 2},
                {1, 4, 4, 5},
                {2, 4, 2, 2},
                {2, 4, 2, 2}
        };
        System.out.println(equalPairs(grid));
    }

    public static int equalPairs(int[][] grid) {
        int n = grid[0].length;
        int[] a = new int[n];
        int[] b = new int[n];
        int count = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                boolean match = true;
                for (int k = 0; k < n; k++) {
                    if (ints[k] != grid[k][j]) {
                        match = false;
                        break;
                    }
                }
                count += match ? 1 : 0;
            }
        }
        return count;
    }
}
