package com.concepts;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReduceTest {
    public static void main(String[] args) {
        List<Integer> numList = List.of(1, 2, 4, 5, 6, 7, 7);
        int reducedNum = numList.stream().reduce(0, Integer::sum);
        System.out.println(reducedNum);

        List<List<Integer>> nestedList = List.of(List.of(1, 3, 4, 5, 8, 8), List.of(2, 9, 8, 9, 9));

        var c = Collections.max(nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
//                .forEach((key, value) -> System.out.println(key + " -- " + value));
                .entrySet(), Map.Entry.comparingByValue());
        System.out.println(c);
    }
}
