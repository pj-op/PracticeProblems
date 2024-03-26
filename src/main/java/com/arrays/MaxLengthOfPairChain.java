package com.arrays;

//https://leetcode.com/problems/maximum-length-of-pair-chain/

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthOfPairChain {
    public static void main(String[] args) {
        int[][] pairs =
                {{1, 2}, {2, 3}, {3, 4}}
//                {{1, 9}, {2, 3}, {3, 6}}
                ;
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
//        System.out.println(Arrays.deepToString(pairs));
        System.out.println(findLongestChain(pairs));

    }

    public static int findLongestChain(int[][] pairs) {
        int res = 0;
        int cur = Integer.MIN_VALUE;
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        for (int[] a : pairs) {
            if (cur < a[0]) {
                cur = a[1];
                res++;
            }
        }
        return res;
    }
}

    /*You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.

        A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.

        Return the length longest chain which can be formed.

        You do not need to use up all the given intervals. You can select pairs in any order.*/