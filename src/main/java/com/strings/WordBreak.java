package com.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
//        String s = "leetcode";
//        String s = "catsandog";
        String s = "applepenapple";
//        List<String> wordDict = Arrays.asList("leet", "code");
//        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        List<String> wordDict = Arrays.asList("apple", "pen");
//        System.out.println(wordBreak(s, wordDict));
        System.out.println(wordBreakUsingRecursion(s, wordDict));
    }

    private static boolean wordBreakUsingRecursion(String s, List<String> wordDict) {
        if (wordDict.contains(s)) return true;
        for (int j = 1; j < s.length(); j++) {
            if (wordDict.contains(s.substring(0, j)) && wordBreakUsingRecursion(s.substring(j), wordDict)) return true;
        }
        return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {

//        wordDict = wordDict.stream().sorted(Comparator.comparing(String::length)).toList();

        for (String word : wordDict) {
            if (s.contains(word)) {
                s = s.replaceFirst(word, "");
            }
        }
        return s.isEmpty();
    }
}
