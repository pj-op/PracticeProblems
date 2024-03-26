package com.arrays;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {
    public static void main(String[] args) {
        int[] nums =
//                {1, 2, 3, 1, 1, 3}
                {1, 1, 1, 1};
        System.out.println(numIdenticalPairs(nums));
    }
    public static int numIdenticalPairs(int[] nums) {
        //Better Way to count and calculate
        /*AtomicLong ans = new AtomicLong(0);
        List<Map.Entry<Integer, Long>> entryList = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .toList();
        System.out.println(entryList);
        entryList.forEach(e -> ans.set(ans.get() + (e.getValue() * (e.getValue() - 1)) / 2));
        return ans.intValue();*/

        //Brute Force Way
        /*int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i < j && nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;*/

        //Using FreqArray
        /*AtomicInteger res = new AtomicInteger(0);
        int maxElement = Integer.MIN_VALUE;
        for (int a : nums) {
            maxElement = Math.max(maxElement, a);
        }
        int[] arr = new int[maxElement + 1];
        for (int a : nums) {
            arr[a]++;
        }

        Arrays.stream(arr)
                .filter(x -> x > 1)
                .boxed()
                .forEach(y -> res.set(res.get() + (y * (y - 1)) / 2));

        return res.get();*/

        //Optimal Way
        int count = 0;
        Map<Integer, Integer> dataMap = new HashMap<>();

        for (int a: nums) {
            int s = dataMap.getOrDefault(a, 0);
            count = count + s;
            dataMap.put(a, s + 1);
        }

        return count;
    }
}
