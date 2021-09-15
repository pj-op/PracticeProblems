package com.gs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MathProblems {
    public static void main(String[] args) {
//       1. Add Fractions
        int fraction1[] = {8, 9};
        int fraction2[] = {-7, 3};

//        System.out.println(Arrays.toString(addFractions(fraction1, fraction2)));

//       2. Is Power of 10
        double numToCheckPowerOf10 = 1;
//        System.out.println(isPowerOf10(numToCheckPowerOf10));

//        3. Power of Expo
        int base = -5;
        int power = -4;
//        System.out.println(powerOfExpo(base, power));

//        4. Prime Factorization
        int numToBeFactorized = 666;
//        System.out.println(findAllPrimeFactors(numToBeFactorized));

//        5. Square root
        int numForSqrt = 5;
//        System.out.println(sqrtOfNum(numForSqrt));

//        6. Decimal Conversion
        long numerator = 4, denominator = 7;
        System.out.println(vulgarToDecimal(numerator, denominator));
    }

    private static String vulgarToDecimal(long nume, long deno) {
        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> remMap = new HashMap<>();

        long div = nume / deno;
        sb.append(div);

        long rem = nume % deno;

        if (rem == 0) return sb.toString();

        sb.append(".");

        while (rem != 0) {
            if (remMap.containsKey(rem)) {
                sb.insert(remMap.get(rem), "(");
                sb.append(")");
                break;
            } else {
                remMap.put(rem, sb.length());
                rem = rem * 10;
                sb.append(rem / deno);
                rem = rem % deno;
            }
        }


        return sb.toString();
    }

    private static double sqrtOfNum(int num) {
        double temp = 0;
        double sr = num / 2;

        do {
            temp = sr;
            sr = (temp + num / temp) / 2;
        } while (temp - sr != 0);


        return sr;
    }

    private static List<Integer> findAllPrimeFactors(int num) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }

        if (num > 1) factors.add(num);

        return factors;
    }

    private static double powerOfExpo(int base, int power) {
        double num = 0;
        double ans = 0;
        if (power == 0) return 1;

        num = powerOfExpo(base, Math.abs(power) / 2);

        if (power % 2 == 0)
            ans = num * num;
        else ans = base * num * num;
        return power < 0 ? 1 / ans : ans;
    }

    private static boolean isPowerOf10(double num) {
        int count = 0;

        while (num > 0 && num < 1) {
            num = num * 10;
            count++;
        }

        while (num >= 10 && num % 10 == 0) {
            count++;
            num = num / 10;
        }
        System.out.println("Power is: " + count);

        return num == 1;


    }

    private static int[] addFractions(int[] f1, int[] f2) {
        if (f1[0] == 0 && f2[0] == 0) return new int[]{0, 0};
        else if (f1[0] == 0 && f2[0] != 0) return f2;
        else if (f1[0] != 0 && f2[0] == 0) return f1;

        int p = 0, q = 0, lcm = 0, gcd = 0;

        lcm = findLCM(f1[1], f2[1]);

        p = (lcm / f1[1]) * f1[0] + (lcm / f2[1]) * f2[0];
        q = lcm;

        gcd = findGDC(Math.abs(p), Math.abs(q));

        p = p / gcd;
        q = q / gcd;

        return new int[]{p, q};
    }

    private static int findGDC(int a, int b) {
        if (a == 0) return b;
        return findGDC(b % a, a);
    }

    private static int findLCM(int a, int b) {
        return (a * b) / findGDC(a, b);
    }
}
