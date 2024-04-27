package com.strings;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        int k = 1;
        //9
        String s = "10";
//        "1231623816273516253"
        System.out.println(removeKdigits2(s, k));
    }

    private static String removeKdigits2(String s, int k) {
        int n = s.length();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < n; i++) {
            while (!res.isEmpty() && res.charAt(res.length() - 1) - '0' > s.charAt(i) - '0' && k > 0) {
                res.deleteCharAt(res.length() - 1);
                k--;
            }
            if (!res.isEmpty() || s.charAt(i) - '0' != 0) {
                res.append(s.charAt(i) - '0');
            }
        }

        while (k > 0 && !res.isEmpty()) {
            res.deleteCharAt(res.length() - 1);
            k--;
        }

        return !res.isEmpty() ? res.toString() : "0";
    }

    private static String removeKdigits(String num, int k) {
        int len = num.length();
        if (k == len) return "0";

        Stack<Integer> stack = new Stack<>();
        stack.push(num.charAt(0) - '0');
        for (int i = 1; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            if (!stack.isEmpty() && stack.peek() <= n || k == 0) {
                stack.push(n);
            } else if (!stack.isEmpty() && k > 0) {
                stack.pop();
                stack.push(n);
                k--;
            }
        }

        //Corner case when all the nums are in increasing order
        while (k > 0) {
            if (!stack.isEmpty()) {
                stack.pop();
                k--;
            }
        }


        StringBuilder sb = new StringBuilder();
        stack.forEach(sb::append);

        return sb.toString();
    }
}
