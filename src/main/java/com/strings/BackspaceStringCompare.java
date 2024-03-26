package com.strings;

import java.util.Stack;

public class BackspaceStringCompare {
    public static void main(String[] args) {
//        String s = "ab#c", t = "ad#c";
//        String s = "ab##", t = "c#d#";
//        String s = "a#c", t = "b";
//        String s = "a##c", t = "#a#c";
        String s = "y#fo##f", t = "y#f#o##f";
//        System.out.println(backspaceCompareOptimal(s, t));
        System.out.println(backspaceCompareOptimalAg(s).equals(backspaceCompareOptimalAg(t)));
    }

    private static String backspaceCompareOptimalAg(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') count++;
            else if (count > 0) count--;
            else sb.append(s.charAt(i));
        }
        System.out.println(sb);
        return sb.toString();
    }

    private static boolean backspaceCompareOptimal(String s, String t) {
        s = findingFromBack(s);
        t = findingFromBack(t);
        return s.equals(t);
    }

    private static String findingFromBack(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '#') count++;
            else if (count != 0) count--;
            else sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static boolean backspaceCompare(String s, String t) {
        var sStack = getStrStack(s);
        var tStack = getStrStack(t);
        return sStack.equals(tStack);
    }

    private static String getStrStack(String str) {
        Stack<Character> strStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (!strStack.isEmpty() && str.charAt(i) == '#') {
                strStack.pop();
            } else if (strStack.isEmpty() && str.charAt(i) == '#') {
                continue;
            } else {
                strStack.push(str.charAt(i));
            }
        }
        return strStack.toString();
    }
}
