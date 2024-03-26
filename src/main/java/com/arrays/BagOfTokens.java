package com.arrays;

import java.util.Arrays;

public class BagOfTokens {
    public static void main(String[] args) {
        int power = 50;
        int[] tokens = {58, 91};
        System.out.println(bagOfTokensScore(tokens, power));
    }

    private static int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        int i = 0;
        int j = n - 1;
        int score = 0;
        int ans = Integer.MIN_VALUE;

        if (n == 1) {
            if (tokens[0] > power) return 0;
            else return 1;
        }

        Arrays.sort(tokens);

        while (i <= j) {
            if (tokens[i] <= power) {
                power -= tokens[i];
                score++;
                i++;
                ans = Math.max(ans, score);
            } else if (score >= 1) {
                power += tokens[j];
                score--;
                j--;
            } else return ans == Integer.MIN_VALUE ? 0 : ans;
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}
