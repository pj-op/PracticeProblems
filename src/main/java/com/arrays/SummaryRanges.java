package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums =
//                {0, 2, 3, 4, 6, 8, 9}
                {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRangesII(nums));
    }

    private static List<String> summaryRangesII(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length < 2) return new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            int start = i;
            int end = i;
            while (end + 1 < nums.length && nums[end + 1] == 1 + nums[end]) end++;
            if (end > start) ans.add(nums[start] + "->" + nums[end]);
            else ans.add(String.valueOf(nums[start]));
            i = end + 1;
        }
        return ans;
    }

    public static List<Integer> summaryRanges(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<String> result = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) ans.add(List.of(nums[i - 1], nums[i]));
            else System.out.println(nums[i]);
        }

        System.out.println(ans);
        //Merging interval

        for (int i = 1; i < ans.size(); i++) {
            if (ans.get(i - 1).get(1).compareTo(ans.get(i).get(0)) == 0) {
                result.add(ans.get(i - 1).get(0) + "->" + ans.get(i).get(1));
            } else if (ans.get(i).size() == 2) {
                result.add(ans.get(i).get(0) + "->" + ans.get(i).get(1));
            }
        }


        System.out.println(result);


        return new ArrayList<>();
    }
}
