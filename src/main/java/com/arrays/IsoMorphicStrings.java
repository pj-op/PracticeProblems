package com.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
    https://leetcode.com/problems/isomorphic-strings/

    Example 1:
        Input: s = "egg", t = "add"
        Output: true
        Example 2:

        Input: s = "foo", t = "bar"
        Output: false
        Example 3:

        Input: s = "paper", t = "title"
        Output: true
* */
public class IsoMorphicStrings {
    public static void main(String[] args) {
        String s = "bada";
        String t = "baba";

//        System.out.println(checkIsoMorphic(s, t));
        System.out.println(checkIsoMorphicAgain(s, t));


//        IntStream.rangeClosed(1,100).filter(x->IntStream.rangeClosed(2,x/2).noneMatch(y->x%y==0)).boxed().forEach(System.out::println);

    }

    private static boolean checkIsoMorphicAgain(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> dataMap = new HashMap<>();
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (dataMap.containsKey(s.charAt(i)) && dataMap.get(s.charAt(i)) != t.charAt(j)) return false;
            else {
                int finalJ = j;
                if (!dataMap.containsKey(s.charAt(i)) && dataMap.entrySet().stream().anyMatch(x -> x.getValue() == t.charAt(finalJ))) return false;
            }
                dataMap.put(s.charAt(i), t.charAt(j));
            i++;
            j++;
        }
        return true;
    }

    public static boolean isIsomorphic(String s, String t) {

        int i = s.length();
        int j = t.length();

        if (i != j) return false;

        Map<Character, Character> map1 = new LinkedHashMap<>();
        Map<Character, Boolean> map2 = new LinkedHashMap<>();

        for (int k = 0; k < i; k++) {

            char sChar = s.charAt(k);
            char tChar = t.charAt(k);

            if (map1.containsKey(sChar)) {
                if (map1.get(sChar) != tChar) return false;
            } else {
                if (map2.containsKey(tChar)) return false;
                else {
                    map1.put(sChar, tChar);
                    map2.put(tChar, true);
                }
            }

        }
        return true;
    }

    public static boolean checkIsoMorphic(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if (l1 != l2) return false;

        int[] arr1 = new int[128];
        Arrays.fill(arr1, -1);

        int[] arr2 = new int[128];
        Arrays.fill(arr2, -1);

        for (int i = 0; i < l1; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (arr1[c1] == -1 && arr2[c2] == -1) {
                arr1[c1] = c2;
                arr1[c2] = c1;
            } else if (!(arr1[c1] == c2 && arr2[c2] == c1)) {
                return false;
            }


        }
        return true;

    }


}
