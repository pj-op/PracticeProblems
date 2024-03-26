package com.arrays;

//https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/

import java.util.Arrays;

public class AvgSalWoMaxMin {
    public static void main(String[] args) {
        int[] salary = {1000, 2000, 3000};
//        System.out.println(average(salary));
        System.out.println(averageOptimal(salary));
    }

    public static double average(int[] salary) {
        return Arrays.stream(salary).sorted().skip(1).limit(salary.length - 2).average().getAsDouble();
    }

    public static double averageOptimal(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int j : salary) {
            max = Math.max(max, j);
            min = Math.min(min, j);
            sum = sum + j;
        }
        return (double) (sum - (max + min)) / (salary.length - 2);
    }

}