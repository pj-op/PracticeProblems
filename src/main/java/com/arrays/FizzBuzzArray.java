package com.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzzArray {
    public static void main(String[] args) {
        int num = 20;
//        fizzBuzzArray(num);

        String[] arr = new String[num];
        System.out.println(Arrays.toString(fizzBuzzArrayRecursion(arr, num)));
    }

    private static String[] fizzBuzzArrayRecursion(String[] arr, int num) {
        if (num == 0) return arr;
        if (num % 15 == 0) arr[num - 1] = "FizzBuzz";
        else if (num % 5 == 0) arr[num - 1] = "Buzz";
        else if (num % 3 == 0) arr[num - 1] = "Fizz";
        else arr[num - 1] = String.valueOf(num);
        return fizzBuzzArrayRecursion(arr, num - 1);
    }

    private static void fizzBuzzArray(int num) {
        int[] arr = new int[num];
        String[] ans = new String[num];
        var res = IntStream.range(0, arr.length)
                .boxed().map(i -> arr[i] = i + 1)
                .map(j -> ans[j - 1] = arr[j - 1] % 15 == 0 ? "FizzBuzz" : arr[j - 1] % 5 == 0 ? "Buzz" : arr[j - 1] % 3 == 0 ? "Fizz" : String.valueOf(j));
        System.out.println(res.collect(Collectors.toList()));
    }
}
