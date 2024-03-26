package com.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

//https://leetcode.com/problems/top-k-frequent-elements/submissions/ - ACCEPTED but not efficient

public class TopKElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topFrequent(nums, k)));
    }

    private static int[] topFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> freqMap = new HashMap<>();
        Arrays.stream(nums).forEach(i -> freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1));
        var sorted = freqMap.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue())).toList();
        IntStream.range(0, ans.length).forEach(i -> ans[i] = sorted.get(i).getKey());
        return ans;
    }
}
