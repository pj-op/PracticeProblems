package com.strings;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllValidPalindromicSubStrings {
    public static void main(String[] args) {
        String str =
                "abccbc"
//                "aabbbaa"
//                "google"
                ;
        System.out.println(findAllPSubStr(str));
    }

    private static List<String> findAllPSubStr(String str) {
        Set<String> ans = new HashSet<>();
        int i = 0, j = i + 1;
        while (i < str.length()) {
            while (j <= str.length()) {
                String testStr = str.substring(i, j);
//                if (testStr.equals(reverseIndividualWord(testStr))) ans.add(testStr);
                if (isPalindrome(testStr)) ans.add(testStr);
                j++;
            }
            i++;
            j = i + 1;
        }
        return ans.stream().toList();
    }

    private static String reverseIndividualWord(String word) {
        int i = 0;
        int j = word.length() - 1;
        char[] charArray = word.toCharArray();

        while (i <= j) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(charArray);
    }

    private static boolean isPalindrome(String inputStr) {
        int i = 0;
        int j = inputStr.length() - 1;
        while (i <= j) {
            char char1 = inputStr.charAt(i);
            char char2 = inputStr.charAt(j);
            if (char1 != char2) return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }
}
