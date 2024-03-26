package com.arrays;

//Letter Combinations of a Phone Number
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        int num = 2;
        char[] alphabet = new char[26];
        List<Character> list = new ArrayList<>();
        //Data Setup
        Map<String, List<Character>> digitMap = new HashMap<>();
        for (int i = 0; i <= alphabet.length; i++) {
            if ((num == 7 || num == 9) ? list.size() == 4 : list.size() == 3) {
                digitMap.put(String.valueOf(num), list);
                list = new ArrayList<>();
                num++;
            }
            list.add((char) (i + 'a'));
        }
        return letterCombinations(digits, digitMap);
    }

    public static List<String> letterCombinations(String digits, Map<String, List<Character>> dataMap) {
        List<String> resultList = new ArrayList<>();



        return resultList;
    }
}
