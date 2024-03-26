package com.strings;

import java.util.Map;
import java.util.Stack;

public class SmallestNumberAfterKDigitsRemoval {
    public static void main(String[] args) {
        String num = "10200";
        int k = 1;
        System.out.println(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k) {
        String ans = "";
        /*if (num.length() < k) return "0";
        String s = "";
        String ans = String.valueOf(Integer.MIN_VALUE);
        for (int i = 0; i + k < num.length(); i++) {
            s = num.substring(i, i + k);
            ans = String.valueOf(Math.max(Integer.parseInt(ans), Integer.parseInt(s)));
        }
        return ans;*/

       /* Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            stack.push()
        }

        return*/
        return null;
    }
}
