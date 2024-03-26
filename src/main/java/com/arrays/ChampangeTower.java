package com.arrays;

import java.util.Arrays;

public class ChampangeTower {
    public static void main(String[] args) {
//        System.out.println(printPascalTriangle());
        int poured = 2, query_row = 1, query_glass = 1;
        System.out.println(champagneTower(poured, query_row, query_glass));
    }

    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[][] res = new double[101][101];
        res[0][0] = poured;
        for (int i = 0; i < res.length - 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (res[i][j] >= 1) {
                    res[i + 1][j] += (res[i][j] - 1) / 2.0;
                    res[i + 1][j + 1] += (res[i][j] - 1) / 2.0;
                    res[i][j] = 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(res));
        return res[query_row][query_glass];
    }
}
