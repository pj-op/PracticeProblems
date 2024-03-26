package com.new_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CryptArithmetic {
    public static void main(String[] args) {
//        String s1 = "SEND", s2 = "MORE" ,s3 = "MONEY";
//        String s1 = "BASE", s2 = "BALL", s3 = "GAMES";
//        String s1 = "FREE", s2 = "BIRD", s3 = "CAGE";
//        String s1 = "WINTER", s2 = "SUMMER", s3 = "AUTUMN";
        //Multiplication
//        String s1 = "JE", s2 = "BB", s3 = "BADE";
        String s1 = "HE", s2 = "EH", s3 = "HNME";

        solveCryptStr(s1, s2, s3);
    }

    private static void solveCryptStr(String s1, String s2, String s3) {
        boolean[] usedNums = new boolean[10];
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> numCharMap = new HashMap<>();
        prepareMapCharNum(numCharMap, sb, Arrays.asList(s1, s2, s3));

        solveCryptStrings(sb, 0, usedNums, numCharMap, s1, s2, s3);
    }

    private static void solveCryptStrings(StringBuilder uniqueStr, int idx, boolean[] usedNums, Map<Character, Integer> numCharMap, String s1, String s2, String s3) {

        if (numCharMap.get(s1.charAt(0)) == 0 || numCharMap.get(s2.charAt(0)) == 0 || numCharMap.get(s3.charAt(0)) == 0)
            return;

        if (idx == uniqueStr.length()) {
            int n1 = getNumFromMapping(s1, numCharMap);
            int n2 = getNumFromMapping(s2, numCharMap);
            int n3 = getNumFromMapping(s3, numCharMap);

            if (n1 * n2 == n3) System.out.println("n1: " + n1 + ", n2: " + n2 + ", n3: " + n3);
            return;
        }

        char ch = uniqueStr.charAt(idx);
        for (int i = 0; i <= 9; i++) {
            if (!usedNums[i]) {
                usedNums[i] = true;
                numCharMap.put(ch, i);
                solveCryptStrings(uniqueStr, idx + 1, usedNums, numCharMap, s1, s2, s3);
                usedNums[i] = false;
                numCharMap.put(ch, -1);
            }
        }
    }

    private static int getNumFromMapping(String string, Map<Character, Integer> numCharMap) {
        int left = 0;
        StringBuilder sb = new StringBuilder();
        while (left < string.length()) {
            char ch = string.charAt(left++);
            sb.append(numCharMap.get(ch));
        }
        return Integer.parseInt(sb.toString());
    }

    private static void prepareMapCharNum(Map<Character, Integer> numCharMap, StringBuilder sb, List<String> list) {
        for (String str : list) {
            int left = 0;
            while (left < str.length()) {
                char ch = str.charAt(left++);
                if (!numCharMap.containsKey(ch)) {
                    numCharMap.put(ch, -1);
                    sb.append(ch);
                }
            }
        }
    }
}
