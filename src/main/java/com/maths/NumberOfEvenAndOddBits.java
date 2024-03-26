package com.maths;

import java.util.Arrays;

public class NumberOfEvenAndOddBits {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(Arrays.toString(evenOddBit(n)));
    }

    public static int[] evenOddBit(int n) {
        int count = 0;
        int[] res = new int[2];
        String bin = Integer.toBinaryString(n);
        int right = bin.length() - 1;
        while (right >= 0) {
            int inComingChar = bin.charAt(right) - '0';
            if (inComingChar == 1) {
                if (count % 2 == 0) res[0]++;
                else res[1]++;
            }
            count++;
            right--;
        }
        return res;
    }
}
