package com.datastruct;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

class SmallestInfiniteSet {
    Queue<Integer> integers = null;

    public SmallestInfiniteSet() {
        integers = new PriorityQueue<>();
        for (int i = 1; i <= 1000; i++) {
            integers.add(i);
        }
    }

    public int popSmallest() {
        int x = integers.poll();
        return x;
    }

    public void addBack(int num) {
        if(!integers.contains(num)) {
            integers.add(num);
        }
    }
}