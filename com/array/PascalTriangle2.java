package com.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
    public static void main(String[] args) {
        int rowIndex = 1;
        System.out.println(pascalTriangle(rowIndex));
    }

    private static List<Integer> pascalTriangle(int rowIndex) {
        List<List<Integer>> pascal = new ArrayList();
        List<Integer> a1 = new ArrayList<>();

        a1.add(1);
        pascal.add(a1);

        for (int i = 1; i < rowIndex + 1; i++) {
            List<Integer> a2 = pascal.get(i - 1);
            List<Integer> a3 = new ArrayList<>();

            a3.add(1);
            for (int j = 1; j < i; j++) {
                a3.add(a2.get(j) + a2.get(j - 1));
            }
            a3.add(1);
            pascal.add(a3);
        }
//        pascal.forEach(System.out::println);

        return pascal.get(rowIndex);
    }
}
