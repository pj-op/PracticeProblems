package com.oops;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/


import javax.sound.midi.Soundbank;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestSubstringWithoutRepeatingChrs {
    public static void main(String[] args) {
//        String str = "abcabc";bbbbb;pwwkew
        String str = "bbbbb";
//        IntStream.rangeClosed(1, 1000).filter(x -> IntStream.rangeClosed(2, (int) Math.sqrt(x)).noneMatch(y -> x % y == 0)).forEach(System.out::println);

        System.out.println(getLongestSubStrLength(str));
    }

    private static int getLongestSubStrLength(String str) {
        int i = 0, count = 0;
        StringBuilder sb = new StringBuilder();

        while (i < str.length() - 1) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                sb = sb.append(str.charAt(i + 1));
                count++;
            }
            i++;
        }

        System.out.println(count);
        System.out.println(sb.toString());

        return 0;
    }
}
