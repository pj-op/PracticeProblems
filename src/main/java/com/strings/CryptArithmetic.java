package com.strings;

import java.util.HashMap;
import java.util.Map;

public class CryptArithmetic {
    static Map<Character, Integer> charMap = new HashMap<>();

    public static void main(String[] args) {

        String s1 = "SEND";
        String s2 = "MORE";
        String s3 = "MONEY";

        StringBuilder uniqueStr = new StringBuilder();
        prepareCharIntMap(s1, uniqueStr);
        prepareCharIntMap(s2, uniqueStr);
        prepareCharIntMap(s3, uniqueStr);

        boolean[] numArr = new boolean[10];
        System.out.println(uniqueStr);
        cryptSolution(uniqueStr, 0, numArr, s1, s2, s3);
    }

    private static void cryptSolution(StringBuilder uniqueStr, int idx, boolean[] numArr, String s1, String s2, String s3) {

        if (idx == uniqueStr.length()) {
            int n1 = getNum(s1);
            int n2 = getNum(s2);
            int n3 = getNum(s3);

            if (n1 + n2 == n3) System.out.println("n1: " + n1 + ", n2: " + n2 + ", " + n3);
            return;
        }

        char ch = uniqueStr.charAt(idx);
        for (int num = 0; num <= 9; num++) {
            if (!numArr[num]) {
                charMap.put(ch, num);
                numArr[num] = true;
                cryptSolution(uniqueStr, idx + 1, numArr, s1, s2, s3);
                numArr[num] = false;
                charMap.put(ch, -1);
            }
        }
    }

    private static int getNum(String inputString) {
        int pointer = 0;
        StringBuilder sb = new StringBuilder();
        while (pointer < inputString.length()) {
            sb.append(charMap.get(inputString.charAt(pointer++)));
        }
        return Integer.parseInt(sb.toString());
    }

    private static void prepareCharIntMap(String str, StringBuilder sb) {
        for (char ch : str.toCharArray()) {
            if (!charMap.containsKey(ch)) {
                charMap.put(ch, -1);
                sb.append(ch);
            }
        }
    }
}
