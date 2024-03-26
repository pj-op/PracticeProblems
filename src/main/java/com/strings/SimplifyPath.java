package com.strings;

//https://leetcode.com/problems/simplify-path/description/ : ACCEPTED

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String path =
                "/home//foo/";
//                "/../";
//                "/home/..";
//                "/home/";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        for (String s : path.split("/")) {
            if (!s.equals(".") && !s.equals("") && !s.equals("..")) {
                stack.push(s);
            }
            if (!stack.isEmpty() && s.equals("..")) {
                stack.pop();
            }
        }
        return "/" + String.join("/", stack.stream().toList());
    }
}
