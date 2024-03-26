package com.epamgenesis;

import java.util.List;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FindLongestWord {
    public static void main(String[] args) {
        String str = "this";
        String line = "hello";
        System.out.println(wordHaveGreatestNumberOfVowelsFromLine(line));
    }

    public static String findLongestWord(String line) {

        System.out.println("Input Test Case: " + line);

        if (null == line || line.isEmpty()) return null;
        if (!line.contains(" ")) return line;

        String ans = null;
        int len = Integer.MIN_VALUE;

        for (String str : line.split(" ")) {
            if (str.length() > len) {
                len = str.length();
                ans = str;
            }
        }
        return ans;
    }

    public static String wordHaveGreatestNumberOfVowelsFromLine(String line) {
        if (null == line || line.isEmpty()) return null;
        if (line.length() == 1 && line.contains("[aeiou]")) return line;

        String ans = null;
        List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");

        int res = Integer.MIN_VALUE;
        for (String words : line.split(" ")) {
            String inputWord = words;
            int count = 0;
            for (String ch : inputWord.split("")) {
                if (vowels.contains(ch)) count++;
            }
            if (count > res) {
                res = count;
                ans = inputWord;
            }
        }
        return ans.contains("[aeiou]") ? ans : null;
    }

}
