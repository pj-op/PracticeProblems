package com.arrays;

import lombok.Data;

import java.util.*;
import java.util.stream.IntStream;

public class WeakestRow {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};
        int k = 3;
        System.out.println(Arrays.toString(kWeakestRows1(mat, k)));
    }

    private static int[] kWeakestRows1(int[][] mat, int k) {
        int[] result = new int[k];
        int[][] rowNumCountOf1 = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            int countOf1 = 0;
            for (int a : mat[i]) {
                countOf1 += a;
            }
            rowNumCountOf1[i][0] = i;
            rowNumCountOf1[i][1] = countOf1;
        }
        Arrays.sort(rowNumCountOf1, (o1, o2) -> o1[1] == o2[1] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
        IntStream.range(0, result.length).forEach(i -> result[i] = rowNumCountOf1[i][0]);
        return result;
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] count = {0, 0};
        int[] result = new int[k];
        List<ZeroOneIndex> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int[] a = mat[i];
            for (int c : a) {
                if (c == 1) {
                    count[c]++;
                }
            }
            list.add(new ZeroOneIndex(i, count[1]));
            count[1] = 0;
        }
        System.out.println(list);
        list.sort((o1, o2) -> {
                    if (o1.getCountOf1() == o2.getCountOf1()) return Integer.compare(o1.fIndex, o2.fIndex);
                    else return Integer.compare(o1.countOf1, o2.countOf1);
                }
        );

//        System.out.println(list);
        IntStream.range(0, result.length).forEach(i -> result[i] = list.get(i).fIndex);
        return result;
    }

}

class ZeroOneIndex {
    int fIndex;
    int countOf1;

    public ZeroOneIndex(int fIndex, int countOf1) {
        this.fIndex = fIndex;
        this.countOf1 = countOf1;
    }

    public int getfIndex() {
        return fIndex;
    }

    public void setfIndex(int fIndex) {
        this.fIndex = fIndex;
    }

    public int getCountOf1() {
        return countOf1;
    }

    public void setCountOf1(int countOf1) {
        this.countOf1 = countOf1;
    }
}
