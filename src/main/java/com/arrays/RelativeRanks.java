package com.arrays;

import java.util.*;

public class RelativeRanks {
    public static void main(String[] args) {

        Random random = new Random();
        int[] score = {37, 12, 28, 9, 100, 56, 80, 5, 12};
//                new int[random.nextInt(20)];
//        IntStream.range(0, score.length).forEach(i -> score[i] = random.nextInt(10));
//        System.out.println(Arrays.toString(findRelativeRanks(score)));
        System.out.println("Input Array: " + Arrays.toString(score));
        System.out.println(Arrays.toString(findRelativeRanksWithDuplicatesOptimal(score)));
    }

    private static int[] findRelativeRanksWithDuplicatesOptimal(int[] score) {
        int[] result = new int[score.length];
        int[] temp = Arrays.copyOf(score, score.length);
        Arrays.sort(temp);
        System.out.println(Arrays.toString(temp));
        Map<Integer, Integer> indexMap = new HashMap<>();
        int rank = 0;
        for (int a : temp) {
            if (!indexMap.containsKey(a)) {
                indexMap.put(a, ++rank);
            }
        }
        System.out.println(indexMap);
        for (int i = 0; i < score.length; i++) {
            if (indexMap.containsKey(score[i])) {
                result[i] = indexMap.get(score[i]);
            }
        }
        return result;
    }

    private static int[] findRelativeRanksWithDuplicates(int[] arr) {
        int[] result = new int[arr.length];
        Queue<NodeWithIndex> pq = new PriorityQueue<>(Comparator.comparing(NodeWithIndex::getNode));
        int idx = 0;
        for (int element : arr) pq.add(new NodeWithIndex(element, idx++));
        int rank = 0;
        int prevElement = 0;
        while (!pq.isEmpty()) {
            NodeWithIndex node = pq.poll();
            if (prevElement == node.node) {
                result[node.index] = rank;
            } else {
                result[node.index] = ++rank;
            }
            prevElement = node.node;
        }
        return result;
    }

    public static String[] findRelativeRanks(int[] score) {
        String[] ranks = {"", "Gold Medal", "Silver Medal", "Bronze Medal"};
        /*String[] result = new String[score.length];
        Queue<NodeWithIndex> pq = new PriorityQueue<>(Comparator.comparing(NodeWithIndex::getNode).reversed());
        int idx = 0;
        for (int element : score) pq.add(new NodeWithIndex(element, idx++));
        int rank = 0;
        while (!pq.isEmpty()) {
            NodeWithIndex node = pq.poll();
            ++rank;
            if (rank < ranks.length) {
                result[node.index] = ranks[rank];
            } else {
                result[node.index] = String.valueOf(rank);
            }
        }
        return result;*/

        String[] result = new String[score.length];
        int[] temp = Arrays.copyOf(score, score.length);
        Arrays.sort(temp);
        Map<Integer, Integer> indexMap = new HashMap<>();
        int rank = 0;
        for (int i = temp.length - 1; i >= 0; i--) {
            if (!indexMap.containsKey(temp[i])) {
                indexMap.put(temp[i], ++rank);
            }
        }
        System.out.println(indexMap);
        for (int i = 0; i < score.length; i++) {
            if (indexMap.containsKey(score[i])) {
                if (indexMap.get(score[i]) < ranks.length) {
                    result[i] = ranks[i + 1];
                } else {
                    result[i] = String.valueOf(indexMap.get(score[i]));
                }
            }
        }
        return result;
    }
}

class NodeWithIndex {
    int node;
    int index;

    public NodeWithIndex(int node, int index) {
        this.node = node;
        this.index = index;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "NodeWithIndex{" +
                "node=" + node +
                ", index=" + index +
                '}';
    }
}