
package com.dp;

public class OptimalPath {

	public static void main(String[] args) {

		Integer[][] grid = { { 0, 0, 0, 0, 5 }, { 0, 1, 1, 1, 0 }, { 2, 0, 0, 0, 0 } };

//		Integer[][] grid = {{0, 1, 1},
//							{0, 1, 2}};

		System.out.println(optimalPath(grid));

	}

	public static Integer optimalPath(Integer[][] grid) {

		int col = grid[0].length;
		int row = grid.length;

		Integer[][] dp = new Integer[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// System.out.print(grid[i][j] + " ");
				dp[i][j] = 0;
			}
			// System.out.println();
		}
		return DP(grid, dp, row - 1, 0, row, col);

//		 for(int i =0 ;i< row ; i ++) {
//				for(int j = 0; j < col ; j++) {
//					System.out.print(dp[i][j] + " ");
//				}
//				System.out.println();
//			}
		// return 0;
	}

	public static Integer DP(Integer[][] grid, Integer[][] dp, int i, int j, int row, int col) {

		if (i < 0 || j > col - 1)
			return 0;

		return dp[i][j] = grid[i][j] + Math.max(DP(grid, dp, i - 1, j, row, col), DP(grid, dp, i, j + 1, row, col));
	}

}
