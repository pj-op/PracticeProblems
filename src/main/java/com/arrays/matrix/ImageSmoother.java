package com.arrays.matrix;

import java.util.Arrays;

public class ImageSmoother {
    public static void main(String[] args) {
        int[][] img = {
                /*{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},*/
                /*{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}*/
                {100, 200, 100},
                {200, 50, 200},
                {100, 200, 100}
        };
        System.out.println(Arrays.deepToString(imageSmoother(img)));
    }

    public static int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;

        int[][] ans = new int[n][m];

        int[] delRow = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] delCol = {-1, 0, 1, -1, -1, 0, 1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = 1;
                int total = img[i][j];
                for (int k = 0; k < delRow.length; k++) {
                    int nRow = i + delRow[k];
                    int nCol = j + delCol[k];

                    if (nRow < n && nCol < m && nRow >= 0 && nCol >= 0) {
                        count++;
                        total += img[nRow][nCol];
                    }
                }
                ans[i][j] = total / count;
            }
        }
        return ans;
    }
}
