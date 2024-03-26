package com.strings;

//https://leetcode.com/problems/roman-to-integer/

/*
Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
*/

import java.util.HashMap;
import java.util.Map;

public class Roman2Integer {
    public static void main(String[] args) {
        //TEST CASE
        /*
        Input: s = "LVIII"
        Output: 58
        Explanation: L = 50, V= 5, III = 3.

        Input: s = "MCMXCIV"
        Output: 1994
        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
        */

        String s =
                "MCMXCIV"
//                "III"
//                "LVIII"
//                "MCDLXXVI"
                ;
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        //Data Setup
        Map<Character, Integer> romanToIntMap = new HashMap<>();
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);

        int ans = romanToIntMap.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            int secLast = romanToIntMap.get(s.charAt(i));
            int last = romanToIntMap.get(s.charAt(i + 1));
            if (secLast < last) {
                ans = ans - secLast;
            } else {
                ans = ans + secLast;
            }
        }
        return ans;
    }
}
