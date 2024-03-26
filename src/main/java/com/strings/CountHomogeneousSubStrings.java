package com.strings;

import java.util.HashMap;
import java.util.Map;

public class CountHomogeneousSubStrings {
    public static void main(String[] args) {
        String str = "abbcccaa";
        System.out.println(countHomogenousOptimal(str));
    }

    public static int countHomogenousOptimal(String s) {
        int MOD = 1_00_000_0007;
        int res = 0;
        int start = 0;
        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[start] != sChars[i]) {
                int appear = i - start;
                while (appear > 0) {
                    res += appear;
                    appear -= 1;
                }
                start = i;
            }
        }
        int appear = sChars.length - start;
        while (appear > 0) {
            res += appear;
            appear -= 1;
        }
        return res % MOD;
    }

    public static int countHomogenous(String s) {
        int MOD = 1_00_000_0007;

        Map<String, Integer> freqMap = new HashMap<>();

        int i = 0;
        int j = 0;

        while (i < s.length()) {
            while (j < s.length()) {
                String inputStr = s.substring(i, j + 1);
                if (isHomogeneous(inputStr)) {
                    freqMap.put(inputStr, freqMap.getOrDefault(inputStr, 0) + 1);
                }
                j++;
            }
            i++;
            j = i;
        }
        return freqMap.values().stream().mapToInt(Integer::intValue).sum() % MOD;
    }

    private static boolean isHomogeneous(String inputString) {
        if (inputString.length() == 1) return true;
        for (int i = 1; i < inputString.length(); i++) {
            if (inputString.charAt(i - 1) != inputString.charAt(i)) return false;
        }
        return true;
    }
}
