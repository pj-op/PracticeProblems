package com.concepts;

import java.util.Arrays;
import java.util.Comparator;

public class PreBuildSorting {
    public static void main(String[] args) {
        testConcept();
    }

    private static void testConcept() {
        String s = "This is Pranjal Soni";
        String ans = Arrays.stream(s.split(" "))
                .max(Comparator.comparing(String::length))
                .orElse(null);
        System.out.println(ans);
    }
}
