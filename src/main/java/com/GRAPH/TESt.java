package com.GRAPH;

import java.util.stream.IntStream;

public class TESt {
    public static void main(String[] args) {
        System.out.println(countOdds(806545180, 881747173));
    }

    public static int countOdds(int low, int high) {
        return (int) IntStream.rangeClosed(low, high)
                .filter(num -> num % 2 != 0)
                .count();
    }
}
