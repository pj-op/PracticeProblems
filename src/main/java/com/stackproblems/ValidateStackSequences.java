package com.stackproblems;

//https://leetcode.com/problems/validate-stack-sequences/ ACCEPTED

import java.util.Stack;

public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed, popped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;
        int numOfElement = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for (int k : pushed) {
            stack.push(k);
            while (!stack.isEmpty() && j < numOfElement && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == numOfElement;
    }
}
