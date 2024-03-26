package com.arrays;

public class PassPillow {
    public static void main(String[] args) {
        int n = 18, time = 38;
        System.out.println(passThePillow(n, time));
    }

    private static int passThePillow(int n, int time) {
        int res = 1;
        int step = 1;
        while (time > 0) {
            res = res + step;
            if (res == n) step = -1;
            if (res == 1) step = 1;
            time--;
        }
        return res;
    }
}
