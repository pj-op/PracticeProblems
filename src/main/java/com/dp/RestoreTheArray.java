package com.dp;

public class RestoreTheArray {
    static int mod = 1000000007;

    public static void main(String[] args) {
        String s = "1317";
        int k = 2000;
        System.out.println(numberOfArrays(s, k));
    }

    static int numberOfArrays(String s, int k) {
        int[] dp = new int[s.length() + 1];
        return dfs(dp, 0, s, k);
    }

    static int dfs(int[] dp, int startIndex, String s, int k) {
        int count = 0;
        if (dp[startIndex] != 0) return dp[startIndex];
        if (startIndex == s.length()) return 1;
        if (s.charAt(startIndex) == '0') return 0;
        for (int i = startIndex; i < s.length(); i++) {
            String currNumber = s.substring(startIndex, i + 1);
            if (Long.parseLong(currNumber) > k) break;
            count = (count + dfs(dp, i + 1, s, k)) % mod;
        }
        dp[startIndex] = count;
        return count;
    }
}
