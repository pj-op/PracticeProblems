package com.arrays;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class KthSmallestLargestElementInArray {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[3];
        IntStream.range(0, arr.length).forEach(i -> arr[i] = random.nextInt(20));
        System.out.println(Arrays.toString(arr));
        System.out.println(kthLargestOptimal(arr, 3));
//        System.out.println(findKthElement(arr, 3, false));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int kthLargestOptimal(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int[] count = new int[max - min + 1];
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - min]++;
        }

        System.out.println(Arrays.toString(count));
//        System.out.println(Arrays.toString(nums));

        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] >= k) {
                return min + i;
            }
            k -= count[i];
        }

        return min;
    }

    private static int findKthElement(int[] arr, int k, boolean isSmallest) {
        // Smallest > Max Heap
        // Largest > Min Heap

        Queue<Integer> pq;

        if (isSmallest) {
            pq = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue).reversed());
        } else {
            pq = new PriorityQueue<>();
        }

        for (int j : arr) {
            pq.add(j);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        System.out.println(pq);
        return pq.isEmpty() ? -1 : pq.poll();
    }
}
