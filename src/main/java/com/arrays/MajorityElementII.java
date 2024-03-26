package com.arrays;

//https://leetcode.com/problems/majority-element-ii/?envType=daily-question&envId=2023-10-05

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MajorityElementII {
    public static void main(String[] args) {
        int[] nums =
//                {3, 2, 3}
                {1, 2};
        System.out.println(majorityElementUsingMooresVotingAlgoList(nums));
    }

    //Majority ELEMENT 1 - Solution
    private static int majorityElementUsingMooresVotingAlgo(int[] nums) {
        //Moore's Voting Algorithm:
        /*
        Assume the first element as the majority element and sequentially traverse and increase the
        count variable when the incoming element is not equal to the current element decrease the count by 1
        at the end the element which stays wins.
         */
        int count = 0;
        int element = 0;

        for (int a : nums) {
            if (count == 0) {
                element = a;
                count++;
            } else if (a == element) {
                count++;
            } else {
                count--;
            }
        }
        int count1 = 0;
        for (int a : nums) {
            if (a == element) count1++;
        }

        return count1 > nums.length / 2 ? element : -1;
    }

    //Majority ELEMENT 2 - Solution
    private static List<Integer> majorityElementUsingMooresVotingAlgoList(int[] nums) {
        //Moore's Voting Algorithm:
        int count1 = 0;
        int count2 = 0;
        int element1 = 0;
        int element2 = 0;

        for (int a : nums) {
            if (count1 == 0 && a != element2) {
                element1 = a;
                count1++;
            } else if (count2 == 0 && a != element1) {
                element2 = a;
                count2++;
            } else if (a == element1) {
                count1++;
            } else if (a == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        int firstEleCount = 0;
        int secEleCount = 0;

        for (int a : nums) {
            if (a == element1) firstEleCount++;
            else if (a == element2) secEleCount++;
        }

        List<Integer> ans = new ArrayList<>();
        if(firstEleCount>nums.length/3)ans.add(element1);
        if(secEleCount>nums.length/3)ans.add(element2);

        return ans;
    }

    public static List<Integer> majorityElement(int[] nums) {
        int times = nums.length / 3;
        Stream<Integer> stream = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > times)
                .map(Map.Entry::getKey);

        return stream.toList();
    }
}
