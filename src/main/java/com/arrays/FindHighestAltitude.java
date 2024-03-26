package com.arrays;

import java.math.BigDecimal;
import java.util.Arrays;

public class FindHighestAltitude {
    public static void main(String[] args) {
        int[] gain =
//                {-5, 1, 5, 0, -7}
                {-4, -3, -2, -1, 4, 3, 2};
        System.out.println(BigDecimal.TEN);
        System.out.println(largestAltitude(gain));
    }
    public static int largestAltitude(int[] gain) {
        if (gain.length < 2) return Math.max(gain[gain.length - 1], 0);
        int[] res = new int[gain.length + 1];
        for (int i = 1; i < gain.length; i++) {
            int j = i - 1;
            res[i] = res[j] + gain[j];
        }
        res[res.length - 1] = res[res.length - 2] + gain[gain.length - 1];
        Arrays.sort(res);
        return res[res.length - 1];
    }
}
