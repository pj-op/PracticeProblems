package com.arrays;

import java.util.*;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr));

    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int ele : arr) {
            freqMap.put(ele, freqMap.getOrDefault(ele, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (set.contains(entry.getValue())) {
                return false;
            } else {
                set.add(entry.getValue());
            }
        }
        return true;
    }
}
