package com.strings;

import java.util.Stack;

//https://leetcode.com/problems/removing-stars-from-a-string/description/ : ACCEPTED

public class RemovingStringStars {
    static String removeStarsV2(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '*') {
                stack.add(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String[] testCases = {
                "*abc",
                "erase*****",
                "leet**cod*e",
                "abb*cdfg*****x*",
                "************abc"};
        for (String testCase : testCases) {
            System.out.println(removeStarsV2(testCase));
//            System.out.println(rupesh(testCase));
        }
    }

    static String removeStarsV3TwoPointer(String s) {
        int j = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '*') {
                j--;
            } else if (j >= 0) {
                chars[j] = chars[i];
                j++;
            }
        }
        return j >= 0 ? String.valueOf(chars).substring(0, j) : String.valueOf(chars);
    }

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.add(c);
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char currChar = stack.peek();
            while (!stack.isEmpty() && stack.peek() == '*') {
                stack.pop();
                i++;
            }
            while (!stack.isEmpty() && stack.peek() != '*' && i > 0) {
                stack.pop();
                i--;
            }
            if (!stack.isEmpty() && currChar != '*') {
                sb.append(currChar);
                stack.pop();
            }
        }
        return sb.reverse().toString();
    }

    public static String rupesh(String s) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char[] s1 = s.toCharArray();
            if (s1[i] == '*') {
                j--;
            } else {
                s1[j] = s1[i];
                j++;
            }
        }
        return s.substring(0, j);
    }
}