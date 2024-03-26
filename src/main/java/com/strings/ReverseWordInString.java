package com.strings;

import java.util.Arrays;

public class ReverseWordInString {
    public static void main(String[] args) {
        String str = "  hello world  ";
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String str) {
        String newStr = str.strip().replaceAll("\\s+", " ");
        String[] token = newStr.split(" ");

        int left = 0;
        int right = token.length - 1;

        while (left < right) {
            String temp = token[left];
            token[left] = token[right];
            token[right] = temp;
            left++;
            right--;
        }

        StringBuilder sb = new StringBuilder();
        for (String s : token) {
            sb.append(s);
            sb.append(" ");
        }

        return sb.toString();
    }
}
