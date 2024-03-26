package com.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeastNumberOfCharacterAfterKRemovals {
    public static void main(String[] args) {
        int[] arr =
                {1, 2, 3, 3, 3, 3, 1, 6, 2, 2, 2, 5, 5, 5};
        //{4, 3, 1, 1, 3, 3, 2};
        int k = 4;
        System.out.println(findLeastNumOfUniqueIntsOptimal(arr, k));
    }

    private static int findLeastNumOfUniqueIntsOptimal(int[] arr, int k) {

        int minEle = Integer.MAX_VALUE;
        int maxEle = Integer.MIN_VALUE;

        for (int ele : arr) {
            minEle = Math.min(minEle, ele);
            maxEle = Math.max(maxEle, ele);
        }
        int[] freq = new int[maxEle - minEle + 1];

        for (int ele : arr) {
            freq[ele - minEle]++;
        }

        Arrays.sort(freq);

        int idx = 0;
        while (k > 0) {
            if (freq[idx] > 0) {
                freq[idx]--;
            }
            idx++;
            k--;
        }
        System.out.println(Arrays.toString(freq));

        return (int) Arrays.stream(freq).filter(ele -> ele != 0).count();
    }

    private static int findLeastNumOfUniqueInts(int[] arr, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int ele : arr) {
            freqMap.put(ele, freqMap.getOrDefault(ele, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortedEntries =
                freqMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();

        for (Map.Entry<Integer, Integer> entry : sortedEntries) {
            if (k == 0) break;
            while (k > 0 && entry.getValue() > 0) {
                int key = entry.getKey();
                int val = freqMap.get(key);
                val--;
                freqMap.put(key, val);
                k--;
            }
        }
        for (Map.Entry<Integer, Integer> entry : sortedEntries) {
            if (entry.getValue() == 0) {
                freqMap.remove(entry.getKey());
            }
        }
        return freqMap.size();
    }
}
