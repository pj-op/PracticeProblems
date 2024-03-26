package com.dp;

import java.util.Arrays;

public class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons {

    static int[][][] dp = new int[51][51][101];
    static int n, m, k;
    static int MODULO = 1_00_000_0007;

    public static void main(String[] args) {
//        int n = 2, m = 3, k = 1;
        int n = 5, m = 2, k = 3;
        System.out.println(numOfArrays(n, m, k));
    }

    public static int numOfArrays(int N, int M, int K) {
        n = N;
        m = M;
        k = K;
        Arrays.stream(dp).forEach(arr -> Arrays.stream(arr).forEach(a -> Arrays.fill(a, -1)));
        return solveUsingDp(0, 0, 0);
    }

    private static int solveUsingDp(int index, int lenLis, int large) {
        if (index == n) {
            if (lenLis == k) return 1;
            return 0;
        }
        if (dp[index][lenLis][large] != -1) return dp[index][lenLis][large];
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            if (i > large) ans += solveUsingDp(index + 1, lenLis + 1, i);
            else ans += solveUsingDp(index + 1, lenLis, large);
            ans = ans % MODULO;
        }
        return dp[index][lenLis][large] = ans;
    }
}
