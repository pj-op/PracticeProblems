package com.gs;

import java.util.Arrays;

public class DynamicProgramming {
    public static void main(String[] args) {

//        1. Student Election Program
        int noOfStudents = 4, lengthOfSong = 2;
//        System.out.println(whoIsElected(noOfStudents, lengthOfSong));

//        2. Walking Robot
        String commands = "UUU";
//        System.out.println(Arrays.toString(walk(commands)));

//        Optimal Path and TrainMap Yet to be completed
//        3. Stair Case
        int noOfStepsToBeTraverse = -5;
//        System.out.println(totalUniqueWayOfTraverse(noOfStepsToBeTraverse));

    }

    private static int totalUniqueWayOfTraverse(int steps) {
        if (steps < 0) return 0;
        int dp[] = new int[steps + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[steps];
    }

    private static int[] walk(String commands) {
        int result[] = new int[2];

        for (char c : commands.toCharArray()) {
            if (c == 'U') result[1] += 1;
            if (c == 'D') result[1] -= 1;
            if (c == 'L') result[0] -= 1;
            if (c == 'R') result[0] += 1;

        }

        return result;
    }

    private static int whoIsElected(int n, int k) {
        if (n == 1) return 1;
        return (whoIsElected(n - 1, k) + (k - 1)) % n + 1;
    }
}
