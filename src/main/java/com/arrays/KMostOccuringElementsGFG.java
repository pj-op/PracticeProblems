package com.arrays;

import java.util.*;

public class KMostOccuringElementsGFG {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 5, 5, 1, 7, 8};
        int k = 3;
        System.out.println(kMostFrequent(arr, arr.length, k));
    }

    private static int kMostFrequent(int[] arr, int n, int k) {
        /*int minEle = Integer.MAX_VALUE;
        int maxEle = Integer.MIN_VALUE;

        for (int ele : arr) {
            minEle = Math.min(minEle, ele);
            maxEle = Math.max(maxEle, ele);
        }

        int[] freq = new int[maxEle - minEle + 1];
        for (int ele : arr) {
            freq[ele - minEle]++;
        }*/

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int ele : arr) {
            freqMap.put(ele, freqMap.getOrDefault(ele, 0) + 1);
        }

        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue).reversed());
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.add(entry.getValue());
        }

        int ans = 0;
        while (k > 0 && !pq.isEmpty()) {
            ans += pq.poll();
            k--;
        }

        return ans;
    }
}