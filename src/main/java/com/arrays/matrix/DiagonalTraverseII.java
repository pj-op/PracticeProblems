package com.arrays.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalTraverseII {
    public static void main(String[] args) {
        List<List<Integer>> nums = Arrays.asList(Arrays.asList(14, 12, 19, 16, 9), Arrays.asList(13, 14, 15, 8, 11), Arrays.asList(11, 13, 1));
//        [[14,12,19,16,9],[13,14,15,8,11],[11,13,1]]
        System.out.println(Arrays.toString(findDiagonalOrder(nums)));
    }

    public static int[] findDiagonalOrder(List<List<Integer>> nums) {

        List<Integer> ans = new ArrayList<>();

        int row = nums.size();
        if (row == 1) return nums.get(0).stream().mapToInt(Integer::intValue).toArray();
        int jVal = 1;

        for (int i = 0; i < row; i++) {
            int iVal = i;
            for (int j = 0; j <= i; j++) {
                try {
//                System.out.print(iVal-- + " -- " + j + " ");
//                    System.out.print(nums.get(iVal--).get(j) + " ");
                    ans.add(nums.get(iVal--).get(j));
                } catch (Exception e) {
                    continue;
                }
            }
//            System.out.println();
        }

        for (int i = row - 1; i >= 0; i--) {
            int iVal = i;
            for (int j = jVal; j <= row; j++) {
                try {
//                System.out.print(iVal-- + " -- " + j + " ");
//                    System.out.print(nums.get(iVal--).get(j) + " ");
                    ans.add(nums.get(iVal--).get(j));
                } catch (Exception e) {
                    if (jVal > i) break;
                    continue;
                }
            }
            i = row;
            jVal++;
//            if (jVal > i) break;
//            System.out.println();
        }


        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}