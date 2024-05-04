package com.new_problems;

//There is an array of pile of chocolates, in every iteration Ayushi chose pile with maximum number of chocolates,
// after that square root of chocolate remains and rest is eaten by Ayushi. After k iterations find number of chocolates remaining.

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class DEShaw {
    public static void main(String[] args) {
        int k = 3;
        int[] pile = {25, 64, 9, 4, 100};
        System.out.println(remainingChocolatesII(pile, k));
    }

    private static int remainingChocolatesII(int[] chocolates, int iterations) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < chocolates.length; i++) {
            q.offer(chocolates[i]);
        }
        while (iterations > 0) {
            int curr = q.poll();
            curr = (int) Math.sqrt(curr);
            q.offer(curr);
            iterations--;
        }
        int remainedChocolates = 0;
        while (!q.isEmpty()) {
            remainedChocolates += q.poll();
        }
        return remainedChocolates;
    }

    private static int remainingChocolates(int[] pile, int k) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        IntStream.range(0, pile.length).forEach(index -> queue.add(pile[index]));

        System.out.println(queue);

        while (k > 0) {
            if (!queue.isEmpty()) {
                int curr = queue.poll();
                System.out.println(curr);
                queue.add((int) Math.sqrt(curr));
            }
            k--;
        }

        System.out.println(queue);

        return queue.stream().mapToInt(Integer::intValue).sum();
    }
}
