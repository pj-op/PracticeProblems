package com.strings;

import java.util.Stack;

public class MinimumRemoveMakeValidParentheses {
    public static void main(String[] args) {
        String s =
//                ")))t((u)"
                "a)b(c)d"
//                "lee(t(c)o)de)"
                ;
        System.out.println(minRemoveToMakeValidOptimal(s));
    }

    private static String minRemoveToMakeValidOptimal(String s) {
        int open = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
                sb.append(c);
            } else if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (open > 0) {
                open--;
                sb.append(c);
            }
        }

        int n = sb.length();
        StringBuilder newSb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == '(' && open > 0) {
                open--;
            } else {
                newSb.append(c);
            }
        }

//        System.out.println(sb);
//        System.out.println(newSb);
//        System.out.println(newSb.reverse());

        return newSb.reverse().toString();
    }

    private static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                if (!stack.isEmpty() && c == ')' && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(idx);
                }
            }
            idx++;
        }
        StringBuilder sb = new StringBuilder(s);
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), ' ');
        }
        return sb.toString().replace(" ", "");
    }
}
