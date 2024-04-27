package com.GRAPH;

public class PrintHorizontalAndVerticalNeighbours {
    public static void main(String[] args) {
        char[][] grid = {
                //Test Case : 1
                /*{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}*/
                //Test Case : 2
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    printHVNeigh(i, j, grid, visited);
                }
            }
        }

    }

    private static void printHVNeigh(int row, int col, char[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        visited[row][col] = true;
        int[] delRowArr = {-1, 0, 1, 0};
        int[] delColArr = {0, 1, 0, -1};
        System.out.println("For row: " + row + " and col: " + col);

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRowArr[i];
            int nCol = col + delColArr[i];
            if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == '1' && !visited[nRow][nCol]) {
                System.out.println(" | " + nRow + "," + nCol + " | ");
            }
//            System.out.println();
        }
//        System.out.println();
    }
}
