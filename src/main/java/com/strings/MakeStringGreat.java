package com.strings;

import java.util.Stack;

public class MakeStringGreat {
    public static void main(String[] args) {
        String s = "abBAcC";
        System.out.println(makeGood(s));
    }

    private static String makeGood(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - s.charAt(i)) == 32) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        stack.forEach(sb::append);

        return sb.toString();
    }
}
