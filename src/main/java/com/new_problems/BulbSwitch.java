package com.new_problems;

import java.util.Arrays;

public class BulbSwitch {
    public static void main(String[] args) {
        int testCase = 9;
        /*System.out.println(bulbSwitch(testCase));*/
        System.out.println(bulbSwitchLeetCode(testCase));
    }

    public static int bulbSwitch(int n) {

        if (n < 1) return n;
        int result = 0;
        boolean[] booleans = new boolean[n];
        Arrays.fill(booleans, true);

        for (int i = 1; i < booleans.length; i++) {
            if (i % i == 0) {
                booleans[i] = !booleans[i];
            }
            System.out.println(Arrays.toString(booleans));
        }
//        booleans[booleans.length - 1] = !booleans[booleans.length - 1];
        System.out.println("RESULT: " + Arrays.toString(booleans));

        for (boolean b : booleans) {
            if (b) {
                result++;
            }
        }

        return result;
    }

    public static int bulbSwitchLeetCode(int n) {
        return (int) Math.sqrt(n);
    }
}
