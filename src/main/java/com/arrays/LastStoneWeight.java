package com.arrays;

//https://leetcode.com/problems/last-stone-weight/submissions/ - ACCEPTED

import java.util.*;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] testCase = {1};
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue).reversed());
        Arrays.stream(testCase).forEach(pq::add);
        System.out.println(pq);
        int topElement = 0;
        int nextElement = 0;

        while (pq.size() > 1) {
            topElement = pq.poll();
            nextElement = pq.poll();
            pq.add(Math.abs(topElement - nextElement));
        }

        System.out.println(pq.isEmpty() ? 0 : pq.peek());
    }
}
