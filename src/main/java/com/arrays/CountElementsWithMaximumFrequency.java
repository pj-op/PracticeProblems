package com.arrays;

import java.util.*;
import java.util.stream.IntStream;

public class CountElementsWithMaximumFrequency {
    public static void main(String[] args) {
        int[] nums = {10, 12, 11, 9, 6, 19, 11};
        System.out.println(maxFrequencyElementsWithoutMap(nums));
    }

    private static int maxFrequencyElementsWithoutMap(int[] nums) {
        int maxEle = Integer.MIN_VALUE;

        for (int ele : nums) {
            maxEle = Math.max(maxEle, ele);
        }

        int[] freq = new int[maxEle + 1];

        for (int ele : nums) {
            freq[ele]++;
        }

        int maxFreq = Integer.MIN_VALUE;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        int ans = 0;
        for(int f: freq){
            if(f == maxFreq){
                ans+=f;
            }
        }
        return ans;
    }

    private static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int totalFreq = 0;

        for (int ele : nums) {
            freqMap.put(ele, freqMap.getOrDefault(ele, 0) + 1);
            int freq = freqMap.get(ele);

            if (freq > maxFreq) {
                maxFreq = freq;
                totalFreq = freq;
            } else if (freq == maxFreq) {
                totalFreq += maxFreq;
            }
        }

        return totalFreq;
    }
}

