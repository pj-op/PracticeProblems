package com.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumNumberOperationsMakeArrayEmpty {
    public static void main(String[] args) {
        int[] nums =
//                {2, 3, 3, 2, 2, 4, 2, 3, 4}
                {14, 12, 14, 14, 12, 14, 14, 12, 12, 12, 12, 14, 14, 12, 14, 14, 14, 12, 12};
        System.out.println(minOperationsOptimalAg(nums));
    }

    private static int minOperationsOptimalAg(int[] nums) {
        int ans = 0;
        Map<Integer, Long> freqMap = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        for (long val : freqMap.values()) {
            if (val == 1) {
                return -1;
            }
            ans += (int) Math.ceil((double) val / 3);
        }
        return ans;
    }

    public static int minOperationsOptimal(int[] nums) {
        Map<Integer, Long> freqMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        System.out.println(freqMap);
        int count = 0;
        for (Map.Entry<Integer, Long> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) return -1;
            else count += (int) Math.ceil(entry.getValue() / (3 * 1.0));
        }
        return count;
    }
}
