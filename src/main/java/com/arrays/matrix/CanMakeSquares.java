package com.arrays.matrix;

public class CanMakeSquares {
    public static void main(String[] args) {
        char[][] grid = {
                {'B', 'W', 'B'},
                {'B', 'W', 'W'},
                {'B', 'W', 'B'}
        };
        System.out.println(canMakeSquare(grid));
    }

    public static boolean canMakeSquare(char[][] grid) {

        int[] neighRow = {0, 0, 1, 1};
        int[] neighCol = {0, 1, 0, 1};

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {

                int countOfBlack = 0;
                int countOfWhite = 0;

                for (int k = 0; k < neighCol.length; k++) {
                    int nRow = i + neighRow[k];
                    int nCol = j + neighCol[k];

                    if (nRow < n && nCol < m && nRow >= 0 && nCol >= 0) {
                        if (grid[nRow][nCol] == 'B') {
                            countOfBlack++;
                        } else {
                            countOfWhite++;
                        }
                    }
                }
                if (countOfWhite == 0 || countOfBlack == 0 || countOfBlack == 3 || countOfWhite == 3) {
                    return true;
                }

            }
        }
        return false;
    }
}
