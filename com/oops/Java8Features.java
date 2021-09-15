package com.oops;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Features {

    public static void main(String[] args) {
        List<List<Integer>> nums = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(2, 3, 4, 8, 6, 7, 0));
        System.out.println(nums);

        nums.stream().flatMap(x -> x.stream()).collect(Collectors.toList()).forEach(System.out::print);


    }

}
