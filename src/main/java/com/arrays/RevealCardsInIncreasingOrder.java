package com.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class RevealCardsInIncreasingOrder {
    public static void main(String[] args) {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
    }

    private static int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] ans = new int[n];
        Arrays.sort(deck);

        Queue<Integer> queue = new LinkedList<>();
        IntStream.range(0, n).forEach(queue::add);

        for (int card : deck) {
            if (!queue.isEmpty()) {
                ans[queue.poll()] = card;
            }
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }

        return ans;
    }
}
