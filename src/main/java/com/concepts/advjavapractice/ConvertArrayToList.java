package com.concepts.advjavapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertArrayToList {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        Float[] arr1 = {(float) (0), (float) 2};
        //Note: Here only wrapper works and it doesn't work for primitives
        String[] str_arr = {"abc", "bc", "aab"};

        System.out.println(convertNumberArrayToList(arr1));

    }

    // Here <T> allows any type to call and pass the array
    private static <T> List<T> convertToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    // Here <T extends Number> allows only classes which extends Number are allowed to call
    private static <T extends Number> List<T> convertNumberArrayToList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }
}
