package com.GRAPH;

//https://leetcode.com/problems/surrounded-regions/ : ACCEPTED

import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args) {

        char[][] board = {
                // TEST CASE : 1
                /*{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}*/

                // TEST CASE : 2
                /*
                {'X'}
                */

                //TEST CASE : 3
                /*{'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}*/

                //TEST CASE : 4
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O'}

        };

        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (!visited[i][j] && board[i][j] == 'O') {
                        dfsSR(i, j, board, visited);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        System.out.println(Arrays.deepToString(visited));
        System.out.println(Arrays.deepToString(board));

    }

    private static void dfsSR(int row, int col, char[][] board, boolean[][] visited) {
        int n = board.length;
        int m = board[0].length;

        visited[row][col] = true;
        int[] delRowArr = {-1, 0, 1, 0};
        int[] delColArr = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRowArr[i];
            int nCol = col + delColArr[i];

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && board[nRow][nCol] == 'O' && !visited[nRow][nCol]) {
                visited[nRow][nCol] = true;
                dfsSR(nRow, nCol, board, visited);
            }
        }
    }
}
