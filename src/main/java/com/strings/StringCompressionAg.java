package com.strings;

import java.util.Arrays;

public class StringCompressionAg {
    public static void main(String[] args) {
        char[] chars =
//                {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
//                {'q','w','e'};
//                {'a', 'b', 'b', 'b'};
                {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c'};
        System.out.println(compress(chars));
    }

    private static void printSingleNum(int num) {
        int i = 0;
        while (num > 0) {
            System.out.println(num % 10);
            num = num / 10;
        }
    }

    public static int compress(char[] chars) {
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < chars.length) {
            int count = 0;
            while (j < chars.length && chars[i] == chars[j]) {
                if (chars[i] == chars[j]) {
                    count++;
                    if (count > 1) {
                        chars[j] = ' ';
                    }
                    j++;
                }
            }
            sb.append(chars[i]);
            if (count > 1) {
                sb.append(count);
            }
            i = j;
        }
        System.out.println(sb);
        for (int k = 0; k < sb.length(); k++) {
            chars[k]= sb.charAt(k);
        }
        System.out.println(Arrays.toString(chars));
        return sb.length();
    }
}
