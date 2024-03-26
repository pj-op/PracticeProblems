package com.concepts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class nDArrays {
    public static void main(String[] args) {
        int[][][][] arr = {{{{1, 2, 3, 4}, {5, 6, 7, 8}, {12, 13, 4, 56, 57}}}};

        List<List<List<List<Integer>>>> lists = new ArrayList<>();
        lists = IntStream.range(0, arr.length)
                .mapToObj(i -> IntStream.range(0, arr[i].length)
                        .mapToObj(j -> IntStream.range(0, arr[i][j].length)
                                .mapToObj(k -> IntStream.range(0, arr[i][j][k].length)
                                        .mapToObj(l -> arr[i][j][k][l]).collect(Collectors.toList())).collect(Collectors.toList())).collect(Collectors.toList())).collect(Collectors.toList());


        List<List<Integer>> list = new ArrayList<>();
        int[][] a = {{1, 2, 5}, {7, 4, 6}};

        list = IntStream.range(0, a.length)
                .mapToObj(i -> IntStream.range(0, a[i].length)
                        .mapToObj(j -> a[i][j]).collect(Collectors.toList())).collect(Collectors.toList());
        //Arrays.stream(a).map(i -> Arrays.stream(i).boxed().collect(Collectors.toList())).toList();

        String primeSeries = IntStream.range(2, 999999)
                .filter(x -> IntStream.rangeClosed(2, (int) Math.sqrt(x))
                        .noneMatch(y -> x % y == 0)).boxed().map(String::valueOf)
                .collect(Collectors.joining(","));

        System.out.println(primeSeries);

    }
}
