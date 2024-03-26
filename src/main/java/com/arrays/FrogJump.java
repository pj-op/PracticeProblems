package com.arrays;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.IntStream;

public class FrogJump {
    public static void main(String[] args) {
        int[] arr =
//                {0, 1, 3, 5, 6, 8, 12, 17}
                {0, 1, 2, 3, 4, 8, 9, 11};
//        System.out.println(createMapFrogJump(arr));
        System.out.println(createMapFrogJump1(arr));
    }

    private static boolean createMapFrogJump1(int[] stones) {
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        IntStream.range(0, stones.length).forEach(i -> map.put(stones[i], new TreeSet<>()));
        map.get(stones[0]).add(1);

        for (int i = 0; i < stones.length; i++) {
            int currPos = stones[i];
            for (Integer jump : map.get(currPos)) {
                int pos = jump + currPos;
                if (pos == stones.length - 1) return true;
                if (map.containsKey(pos)) {
                    if (jump - 1 > 0) map.get(pos).add(jump - 1);
                    map.get(pos).add(jump);
                    map.get(pos).add(jump + 1);
                }
            }
        }
        System.out.println(map);
        return false;
    }

    private static boolean createMapFrogJump(int[] arr) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        IntStream.range(0, arr.length).forEach(i -> map.put(arr[i], new HashSet<>()));
        map.get(arr[0]).add(1);
        for (int currPos : arr) {
            Set<Integer> jumps = map.get(currPos);

            for (Integer jump : jumps) {
                int pos = currPos + jump;
                if (pos == arr[arr.length - 1]) return true;
                if (map.containsKey(pos)) {
                    if (jump - 1 > 0) {
                        map.get(pos).add(jump - 1);
                    }
                    map.get(pos).add(jump);
                    map.get(pos).add(jump + 1);
                }
            }
        }
        System.out.println(map);
        return false;
    }
}
