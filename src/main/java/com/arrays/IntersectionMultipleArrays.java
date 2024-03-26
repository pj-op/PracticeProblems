package com.arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntersectionMultipleArrays {
    public static void main(String[] args) {
        int[][] nums =
                {{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}}
//                {{1, 2, 3}, {4, 5, 6}}
                ;
//        System.out.println(intersectionOptimal(nums));
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        System.out.println(Arrays.toString(intersectionOptimalWithDuplicatesUsingRetainAll(num1, num2)));
    }

    private static int[] intersectionOptimalWithDuplicatesUsingRetainAll(int[] num1, int[] num2) {
        Set<Integer> set1 = Arrays.stream(num1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(num2).boxed().collect(Collectors.toSet());
        set1.retainAll(set2);
        return set1.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[] intersectionOptimalWithDuplicates(int[] num1, int[] num2) {
        int[] freqArray = new int[1001];
        Arrays.stream(num1).distinct().forEach(i -> freqArray[i]++);
        Arrays.stream(num2).distinct().forEach(i -> freqArray[i]++);
        return IntStream.range(0, freqArray.length).filter(i -> freqArray[i] >= 2).toArray();
    }

    private static List<Integer> intersectionOptimal(int[][] nums) {
        List<Integer> ans = null;
        int[] freqArray = new int[1001];
        for (int[] num : nums) {
            for (int i : num) {
                freqArray[i]++;
            }
        }
        ans = IntStream.range(0, freqArray.length)
                .filter(i -> freqArray[i] == nums.length)
                .boxed()
                .sorted().toList();

        return ans;
    }

    public static List<Integer> intersection(int[][] nums) {
        List<Integer> ans = new ArrayList<>();

        ans = Arrays.stream(nums)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == nums.length)
                .map(Map.Entry::getKey)
                .sorted().toList();


        return ans;
    }

}
