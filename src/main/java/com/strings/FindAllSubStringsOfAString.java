package com.strings;

import java.util.HashMap;
import java.util.Map;

public class FindAllSubStringsOfAString {
    public static void main(String[] args) {
        String s = "aaaa";
        maximumLength(s);
    }

    private static void maximumLength(String s) {
        int i = 0;
        int j = i + 1;
        Map<String, Integer> freqMap = new HashMap<>();

        while (i < s.length()) {
            while (j <= s.length()) {
                String str = s.substring(i, j);
                int len = str.length();
                boolean flag = false;

                if (len > 1) {
                    int k = 1;
                    while (k < len) {
                        if (str.charAt(k) != str.charAt(k - 1)) {
                            flag = true;
                            break;
                        }
                        k++;
                    }
                }
                if (!flag) {
                    freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);
                }
                j++;
            }
            i++;
            j = i + 1;
        }
        System.out.println(freqMap);
    }
}
