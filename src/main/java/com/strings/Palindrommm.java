package com.strings;

import jsonpractice.LoadJsonData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Palindrommm {
    public static void main(String[] args) {
//        String s = "A man, a plan, a canal, Panama. cooc Was it a car or a cat I saw?";
        String s = new LoadJsonData().readingFile("mkdata/TEST_DOC_Palindrome.txt");

        /*Arrays.stream(s.split("\\s+"))
                .map(str -> str.replaceAll("[^A-Za-z]", "").toLowerCase())
                .filter(Palindrommm::isPalindromic)
                .collect(Collectors.toList());*/

        List<String> ss = findLongestPalindromicWords(
                Arrays.stream(s.split("\\s+"))
                .map(str -> str.replaceAll("[^A-Za-z]", "").toLowerCase())
                .filter(Palindrommm::isPalindromic)
                .collect(Collectors.toList())
        );

        System.out.println(ss);
    }

    private static List<String> findLongestPalindromicWords(List<String> palindroms) {
        List<String> ans = new ArrayList<>();
        int maxLength = 0;
        for (String palin : palindroms) {
            if (palin.length() > maxLength) {
                ans.clear();
                ans.add(palin);
                maxLength = palin.length();
            } else if (palin.length() == maxLength) ans.add(palin);
        }
        return ans;
    }

    public static boolean isPalindromic(String inputString) {
        int startIndex = 0;
        int endIndex = inputString.length() - 1;

        while (startIndex <= endIndex) {
            if (inputString.charAt(startIndex++) != inputString.charAt(endIndex--)) return false;
        }
        return true;
    }
}
