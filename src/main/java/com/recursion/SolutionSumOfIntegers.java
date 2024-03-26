package com.recursion;

public class SolutionSumOfIntegers {
    static int i = 0;

    /**
     * Given an array of integers, find the sum of all the integers using recursion.
     * if the input is invalid return 0.
     *
     * @param input
     * @return
     */
    public static int sumOfIntegers(int[] input) {
        if (input.length == 0) return 0;
        i++;
        if (input.length - i < 0) return 0;
        return input[input.length - i] + sumOfIntegers(input);
    }

    public static void main(String[] args) {
        int[] input = {1, -2, 3, 4, 5};
        System.out.println(sumOfIntegers(input));
    }
}
