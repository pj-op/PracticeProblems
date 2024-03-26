package com.arrays.matrix;

import java.util.Arrays;

public class QuestionsWithBrainPower {
    public static void main(String[] args) {
        int[][] questions = {{3, 2}, {4, 3}, {4, 4}, {2, 5}};
        System.out.println(mostPoints(questions));
    }

    public static long mostPoints(int[][] questions) {
        long ans = 0;
        int score = 0;
        int numOfQuestions = 0;

        for (int i = 0; i < questions.length; i++) {
            score = questions[i][0];
            numOfQuestions = questions[i][1];

            if (i + numOfQuestions >= questions.length - 1) {
                i = questions.length - 1;
            }

            ans = Math.max(ans, numOfQuestions);
        }


        return ans;
    }

    public void test (){}
}
