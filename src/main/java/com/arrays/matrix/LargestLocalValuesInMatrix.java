package com.arrays.matrix;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class LargestLocalValuesInMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                /*{9, 9, 8, 1},
                {5, 6, 2, 6},
                {8, 2, 6, 4},
                {6, 2, 2, 2}*/
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };
        System.out.println(Arrays.deepToString(largestLocal(grid)));
        /*Arrays.stream(grid)
                        .flatMapToInt(Arrays::stream)
                                .sum();
        var res = Collections.max(Arrays.stream(("This is pranjal soni from sagar complex").split(" "))
                        .collect(Collectors.groupingBy(String::length, Collectors.toList()))
                                .entrySet(), Map.Entry.comparingByKey())
                .getValue();

        System.out.println(res);*/

    }

    private static int[][] largestLocal(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int[][] res = new int[row - 2][col - 2];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int ele = grid[i][j];

                if (i + 2 < row && j + 2 < col) {
                    for (int k = i; k <= i + 2; k++) {
                        for (int l = j; l <= j + 2; l++) {
                            //System.out.println(k + " ::: " + l + " ::: " + grid[k][l]);
                            ele = Math.max(ele, grid[k][l]);
                        }
                    }
                    //System.out.println("====================");
                    res[i][j] = ele;
                }
            }
        }
        return res;
    }

}
