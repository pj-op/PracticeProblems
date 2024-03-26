package com.arrays;

//https://leetcode.com/problems/candy/

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        int[] resultArr = new int[ratings.length];
        Arrays.fill(resultArr, 1);
        //first pass
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                resultArr[i] = resultArr[i - 1] + 1;
            }
        }
        //second pass
        for (int i = resultArr.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                resultArr[i] = Math.max(resultArr[i + 1] + 1, resultArr[i]);
            }
        }
        return Arrays.stream(resultArr).sum();
    }
}
