package com.strings;

//https://leetcode.com/problems/is-subsequence

public class IsSuquence {
    public static void main(String[] args) {
        String
                s = "abc", t = "ahbgdc"
//                s = "abc", t = "abc";
        ;
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                count++;
            }
            j++;
        }
        return count==s.length();
    }
}
