package com.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FurthestBuildingUCanReach {
    public static void main(String[] args) {
        /*int[] heights = {4, 2, 7, 6, 9, 14, 12};
        int bricks = 5;
        int ladders = 1;*/
        /*int[] heights = {14, 3, 19, 3};
        int bricks = 17;
        int ladders = 0;*/
        int[] heights = {1, 5, 1, 2, 3, 4, 10000};
        int bricks = 4;
        int ladders = 1;
        /*int[] heights = {4, 12, 2, 7, 3, 18, 20, 3, 19};
        int bricks = 10;
        int ladders = 2;*/
        System.out.println(furthestBuilding(heights, bricks, ladders));
    }

    private static int furthestBuilding(int[] arr, int bricks, int ladders) {
        int n = arr.length;
        if (n == 1) return n;
        int i;
        for (i = 0; i < n - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff > 0) {
                if (bricks > 0 && diff <= bricks) {
                    bricks -= diff;
                } else if (ladders > 0) {
                    ladders -= 1;
                } else {
                    break;
                }
            }
        }
        return i;
    }
}
