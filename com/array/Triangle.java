package com.array;

import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        /*int total = 0;
        List<List<Integer>> tri = Arrays.asList(Arrays.asList(-10));
        total = tri.stream().mapToInt(b -> b.stream().mapToInt(c -> c).min().getAsInt()).reduce((a, b) -> a + b).getAsInt();
        System.out.println(total)*/
        ;
        int n = 00000000000000000000000010000000;
//        System.out.println(7 >>> 1);
        System.out.println(Integer.toBinaryString(121));
        System.out.println("==================");
// prints "1111001"
        System.out.println(Integer.toBinaryString(121 >> 1));
        System.out.println("==================");
// prints "111100"
        System.out.println(Integer.toBinaryString(121 >>> 1));
        System.out.println("==================");
        System.out.println("==================");
        System.out.println(Integer.toBinaryString(-121));
        System.out.println("==================");
// prints "1111001"
        System.out.println(Integer.toBinaryString(-121 >> 1));
        System.out.println("==================");
// prints "111100"
        System.out.println(Integer.toBinaryString(-121 >>> 1));
//        System.out.println(hammingWeight(n));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count = count + (n & 1);
            n = n >>> 1;
        }

        return count;
    }
}
