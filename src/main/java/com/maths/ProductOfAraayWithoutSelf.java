package com.maths;

import java.util.Arrays;

public class ProductOfAraayWithoutSelf {
    public static void main(String[] args) {
        int[] testCase = {1, 2, 3, 4};

        int product = 1;
        for (int a : testCase) {
            product = product * a;
        }

        for (int i = 0; i < testCase.length; i++) {
            testCase[i] = product / testCase[i];
        }

        System.out.println(Arrays.toString(testCase));
    }
}
