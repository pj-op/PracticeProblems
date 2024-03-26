package com.arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumCommonValue {
    public static void main(String[] args) {
        int[] nums1 =
                {1000000000, 1000000000};
//                {1, 2, 3};
        int[] nums2 = {1000000000};
        // {2, 4};
        System.out.println(getCommon(nums1, nums2));
    }

    private static int getCommonUsingMap(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int ele : nums1) {
            if (!freqMap.containsKey(ele)) {
                freqMap.put(ele, 1);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int ele : nums2) {
            if (freqMap.containsKey(ele)) {
                ans = Math.min(ans, ele);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static int getCommon(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int maxEle = Math.max(nums1[n - 1], nums2[m - 1]);
        int[] freq = new int[maxEle + 1];

        for (int ele : nums1) {
            if (freq[ele] == 0) {
                freq[ele]++;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int ele : nums2) {
            if (freq[ele] > 0) {
                ans = Math.min(ans, ele);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
