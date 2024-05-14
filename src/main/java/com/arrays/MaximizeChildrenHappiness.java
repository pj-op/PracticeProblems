package com.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximizeChildrenHappiness {
    public static void main(String[] args) {
        int k = 3;
        int[] happiness = {12, 1, 42};
        System.out.println(maximumHappinessSum(happiness, k));
    }

    private static long maximumHappinessSum(int[] happiness, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int ele : happiness) {
            pq.add(ele);
        }

        int turns = 0;
        long ans = 0;

        while (k > 0) {
            if (!pq.isEmpty()) {
                ans += Math.max(pq.poll() - turns, 0);
            }
            k--;
            turns++;
        }

        return ans;
    }
}
