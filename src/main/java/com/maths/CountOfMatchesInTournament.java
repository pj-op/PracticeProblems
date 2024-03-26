package com.maths;

public class CountOfMatchesInTournament {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(numberOfMatches(n));
    }

    public static int numberOfMatches(int n) {
        int ans = 0;
        int num = n;
        while (num > 0) {
            n /= 2;
            if (n == 0) break;
            ans += n;
            num -= n;
            n = num;
        }
        return ans;
    }
}
