package com.arrays;

public class NumberOf1Bits {
    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight(n));
    }
    public static int hammingWeight(int n) {
        int bitCount = 0;
        return Integer.bitCount(n);
//        return bitCount;
    }
}
