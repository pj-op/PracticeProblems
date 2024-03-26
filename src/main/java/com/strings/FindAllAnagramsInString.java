package com.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i + p.length() < s.length(); i++) {
            System.out.println(s.substring(i, i + p.length()));
        }


        return ans;
    }

    private static int[] freqArray(String p) {
        int[] arr = new int[26];
        for (char c : p.toCharArray()) {
            arr[c - 'a']++;
        }
        return arr;
    }
}
