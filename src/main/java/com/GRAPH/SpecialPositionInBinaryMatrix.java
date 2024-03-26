package com.GRAPH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class SpecialPositionInBinaryMatrix {
    public static void main(String[] args) {
        int[][] mat =
//                {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
                {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(numSpecialOptimal(mat));
    }

    private static int numSpecialOptimal(int[][] mat) {
        int ans = 0;
        int m = mat.length;
        int n = mat[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 1) {
                    rowCount[row]++;
                    colCount[col]++;
                }
            }
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 1) {
                    if (rowCount[row] == 1 && colCount[col] == 1) {
                        ans+=1;
                    }
                }
            }
        }


        return ans;
    }

    public static int numSpecial(int[][] mat) {
        int ans = 0;
        int m = mat.length;
        int n = mat[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 0) continue;

                boolean isSpecial = true;
                for (int r = 0; r < m; r++) {
                    if (r != row && mat[r][col] == 1) {
                        isSpecial = false;
                        break;
                    }
                }

                for (int c = 0; c < n; c++) {
                    if (c != col && mat[row][c] == 1) {
                        isSpecial = false;
                        break;
                    }
                }
                if (isSpecial) ans++;
            }
        }


        return ans;
    }

}

class Pr {
    int row;
    int col;

    Pr(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
