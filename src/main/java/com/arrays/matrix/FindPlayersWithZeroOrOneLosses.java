package com.arrays.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class FindPlayersWithZeroOrOneLosses {
    public static void main(String[] args) {
        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        System.out.println(findWinners(matches));
    }

    public static List<List<Integer>> findWinners(int[][] matches) {

        /*Arrays.sort(matches, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(matches));
        Arrays.sort(matches, Comparator.comparingInt(a -> a[1]));
        System.out.println(Arrays.deepToString(matches));*/
        int n = 100001;
        int m = matches.length;
        int[] winnerFreq = new int[n];
        IntStream.range(0, m).forEach(i -> winnerFreq[matches[i][0]]++);

        int[] looserFreq = new int[n];
        IntStream.range(0, m).forEach(i -> looserFreq[matches[i][1]]++);

        List<Integer> winnerList = new ArrayList<>();
        List<Integer> losersList = new ArrayList<>();

        for (int i = 1; i < winnerFreq.length; i++) {
            if (winnerFreq[i] != 0 && looserFreq[i] == 0) {
                winnerList.add(i);
            }
            if (looserFreq[i] == 1) {
                losersList.add(i);
            }
        }

        return List.of(winnerList, losersList);
    }
}
