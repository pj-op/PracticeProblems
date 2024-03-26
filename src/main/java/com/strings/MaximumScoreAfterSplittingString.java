package com.strings;

public class MaximumScoreAfterSplittingString {
    public static void main(String[] args) {
        String s = "011101";
        System.out.println(maxScore(s));
    }

    public static int maxScore(String s) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, giveScore(s.substring(0, i), true, false) + giveScore(s.substring(i, n), false, true));

        }
        return ans;
    }

    private static int giveScore(String input, boolean isLeft, boolean isRight) {
        int count = 0;
        for (char c : input.toCharArray()) {
            if (isLeft && c == '0') count++;
            if (isRight && c == '1') count++;
        }
        return count;
    }
}
