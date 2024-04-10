package com.arrays;

import java.util.HashMap;
import java.util.Map;

public class LengthofLongestSubarrayWithatMostKFrequency {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2,1,2};
        int k = 1;
        System.out.println(maxSubarrayLength(nums, k));
    }

    private static int maxSubarrayLength(int[] nums, int k) {
        int res = 0;

        Map<Integer, Integer> freqMap = new HashMap<>();

        int i = 0;
        int j = 0;
        int n = nums.length;

        while (j < n) {
            freqMap.put(nums[j], freqMap.getOrDefault(nums[j], 0) + 1);

            while (freqMap.get(nums[i]) > k) {
                if (freqMap.containsKey(nums[i])) {
                    int freq = freqMap.get(nums[i]);
                    freqMap.put(nums[i], freq - 1);
                }
                i++;
            }

            res = Math.max(res, (j - i + 1));

            j++;

        }


        return res;
    }
}
