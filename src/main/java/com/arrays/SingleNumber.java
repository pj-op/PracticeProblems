package com.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {-1, 4, 4, 1, 2, 1, 2};
        System.out.println(singleNumberOptimal(nums));
        Map<Integer,Integer> a = new HashMap<>();
        a.put(1,1);
    }

    private static int singleNumberOptimal(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static int singleNumber(int[] nums) {
        return Arrays.stream(nums)
                .parallel()
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().get();

    }
}
