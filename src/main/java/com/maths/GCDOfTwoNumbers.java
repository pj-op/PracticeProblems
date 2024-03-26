package com.maths;

import java.util.Random;

public class GCDOfTwoNumbers {
    public static void main(String[] args) {
        Random random = new Random();
        int a = 54;
        int b = 24;
        System.out.println("GCD: " + findGCD(a, b));
        System.out.println("GCD: " + (a > b ? findGCDUsingRecursion(a, b) : findGCDUsingRecursion(b, a)));
        System.out.println("LCM: " + (a * b) / findGCD(a, b));
    }

    private static int findGCDUsingRecursion(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCDUsingRecursion(b, a % b);
    }

    private static int findGCD(int a, int b) {
        int gcd = Integer.MIN_VALUE;
        int num = Math.max(a, b);
        for (int i = 1; i <= num; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = Math.max(gcd, i);
            }
        }
        return gcd;
    }
}
