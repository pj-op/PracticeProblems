package com.new_problems;

//https://leetcode.com/problems/consecutive-characters/

//        Input: s = "leetcode"
//        Output: 2
//        Explanation: The substring "ee" is of length 2 with the character 'e' only.


public class ConsecutiveChars {

    public static int maxPower(String s) {
        int count = 0;
        int result = 0, diff = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i + 1; j++) {
                while (s.charAt(i) == s.charAt(j)) {
                    count++;
                }
                diff = j - i;
                result = diff;
            }
        }


        return Math.max(result, diff);
    }

    public static void main(String[] args) {
        maxPower("LeetCode");
    }
}
