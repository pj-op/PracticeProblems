package com.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.IntStream;

public class MaximumSubSeqScore {
    public static void main(String[] args) {
        Random random = new Random();
        Integer[] test = new Integer[random.nextInt(20)];
        IntStream.range(0, test.length).forEach(i -> test[i] = random.nextInt(100));

        System.out.println(Arrays.toString(test));
        Arrays.sort(test, Comparator.reverseOrder());
        System.out.println(Arrays.toString(test));

        int[] nums1 = {1, 3, 3, 2}, nums2 = {2, 1, 3, 4};
        int k = 3;
        System.out.println(maxScore(nums1, nums2, k));
    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; ++i) {
            pairs[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> topKHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        long topKSum = 0;
        for (int i = 0; i < k; ++i) {
            topKSum += pairs[i][0];
            topKHeap.add(pairs[i][0]);
        }

        long answer = topKSum * pairs[k - 1][1];

        for (int i = k; i < n; ++i) {
            topKSum += pairs[i][0] - topKHeap.poll();
            topKHeap.add(pairs[i][0]);
            answer = Math.max(answer, topKSum * pairs[i][1]);
        }

        return answer;
    }
}
