package com.parenthsis;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String parenthesis = "([}}])";
        System.out.println(isValidParenthesis(parenthesis));
    }

    private static boolean isValidParenthesis(String parenthesis) {
        int count = 0;

        if (parenthesis.length() % 2 != 0 || parenthesis.charAt(0) == ')' || parenthesis.charAt(0) == '}' || parenthesis.charAt(0) == ']')
            return false;

        Stack<Character> stack = new Stack<>();

        for (Character c : parenthesis.trim().toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                System.out.println("Original " + stack);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else count++;
        }
        System.out.println(stack);

        return count == 0 ? stack.isEmpty() : false;
    }
}
