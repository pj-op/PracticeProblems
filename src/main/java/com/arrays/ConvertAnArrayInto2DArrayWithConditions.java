package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class ConvertAnArrayInto2DArrayWithConditions {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 1, 2, 3, 1};
        System.out.println(findMatrix(nums));
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int maxEle = Integer.MIN_VALUE;
        int minEle = Integer.MAX_VALUE;
        for (int ele : nums) {
            maxEle = Math.max(ele, maxEle);
            minEle = Math.min(ele, minEle);
        }
        int[] freqEle = new int[maxEle - minEle + 1];
        for (int num : nums) {
            int index = num - minEle;
            if (freqEle[index] >= ans.size()) {
                ans.add(new ArrayList<>());
            }
            ans.get(freqEle[index]).add(num);
            freqEle[index]++;
        }
        return ans;
    }
}
