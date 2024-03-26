package com.strings;

import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString {
    public static void main(String[] args) {
        String[] nums =
                {"111", "011", "001"};
//                {"01", "10", "00"};
        System.out.println(findDifferentBinaryStringOptimal(nums));
    }

    private static String findDifferentBinaryStringOptimal(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }

    public static String findDifferentBinaryString(String[] nums) {

        Set<Integer> integers = new HashSet<>();
        for (String num : nums) {
            integers.add(Integer.parseInt(num, 2));
        }
        System.out.println(integers);

        int n = nums[0].length();
        for (int i = 0; i <= nums.length; i++) {
            if (!integers.contains(i)) {
                String ans = Integer.toBinaryString(i);
                while (ans.length() < n) {
                    ans = "0" + ans;
                }
                return ans;
            }
        }
        return "";
    }
}
