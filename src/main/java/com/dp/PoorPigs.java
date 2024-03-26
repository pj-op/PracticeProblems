package com.dp;

public class PoorPigs {
    public static void main(String[] args) {
        System.out.println(poorPigs(4, 15, 15));
    }

    public static int poorPigs(int b, int m, int n) {
        int c = 0;
        while (Math.pow(n / m + 1, c) < b) {
            c++;
        }
        return c;
    }
}
