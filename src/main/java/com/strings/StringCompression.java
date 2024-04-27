package com.strings;

import java.util.Arrays;

public class StringCompression {

    public static void main(String[] args) {
        char[] s1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        compressString1(s1);
    }

    private static void compressString1(char[] s1) {
        int i = 0;
        int j = 0;

        StringBuilder sb = new StringBuilder();
        while (i < s1.length) {
            sb.append(s1[i]);
            while (j < s1.length && s1[i] == s1[j]) {
                j++;
            }
            int gap = j - i;
            if (gap > 1) sb.append(gap);
            i = j;
        }
        System.out.println(sb.length());

        for (int k = 0; k < sb.length(); k++) {
            s1[k] = sb.charAt(k);
        }

        System.out.println(Arrays.toString(s1));

    }

    public static void compressString(char[] s1) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < s1.length) {
            sb.append(s1[i]);
            while (j < s1.length && s1[i] == s1[j]) j++;
            int diff = j - i;
            if (diff > 1) sb.append(diff);
            i = j;
        }
        for (int k = 0; k < sb.length(); k++) {
            s1[k] = sb.charAt(k);
        }
        System.out.println(Arrays.toString(s1));
        System.out.println(sb.toString());
    }
}
