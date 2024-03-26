package com.strings;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
//        String s = "3[a]2[bc]";
//        String s = "3[a2[c]]";
//        String s = "2[abc]3[cd]ef";
        String s = "5[leetcode]";
        System.out.println(decodeStringPrc(s));
    }

    private static String decodeStringPrc(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        boolean isNum = false;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                numStack.push(c - '0');
            } else if (c != ']') {
                if (c == '[') isNum = true;
                stringStack.push(String.valueOf(c));
            }

            String k = null;
            StringBuilder sk = null;
            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (!stringStack.isEmpty()) {
                    sb.append(stringStack.pop());
                    if (stringStack.peek().equals("[")) {
                        stringStack.pop();
                        break;
                    }
                }
                k = sb.reverse().toString();
                sk = new StringBuilder(k);
                if (!numStack.isEmpty()) {
                    int num = numStack.pop();
                    num = num * 10 + c - '0';
                    while (isNum && num > 1) {
                        sk.append(k);
                        num--;
                    }
                    isNum = false;
                }
            }
            if (k != null) stringStack.push(sk.toString());

        }
        String u = stringStack.stream().reduce((a, b) -> a + b).orElse("");
        System.out.println(u);
        return null;
    }

    private static String decodeStringAgain(String s) {
        Stack<Object> stack = new Stack<>();
        int currNum = 0;
        StringBuilder currString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '[') {
                stack.push(currString.toString());
                stack.push(currNum);
                currNum = 0;
                currString = new StringBuilder();
            } else if (currChar == ']') {
                int num = (int) stack.pop();
                String prevString = String.valueOf(stack.pop());
                String actualString = currString.toString();
                currString.append(actualString.repeat(Math.max(0, num - 1)));
                currString.insert(0, prevString);
            } else if (Character.isDigit(currChar)) {
                currNum = currNum * 10 + currChar - '0';
            } else {
                currString.append(currChar);
            }
        }
        return currString.toString();
    }

    public static String decodeString(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ']') {
                stack.push(i);
            } else if (s.charAt(i) == '[') {
                stack.push(i);
                while (!stack.isEmpty()) {
                    int startIndex = stack.pop();
                    int numIndex = startIndex - 1;
                    if (!stack.isEmpty()) {
                        int poppingIndex = stack.pop();
                        if (startIndex + 1 < s.length() && s.charAt(poppingIndex) == ']') {
                            int appearance = s.charAt(numIndex);
                            while (appearance > 0) {
                                sb.append(s, startIndex + 1, poppingIndex);
                                appearance--;
                            }
                            System.out.println(sb);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(sb);
        return null;
    }
}