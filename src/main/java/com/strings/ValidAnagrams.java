package com.strings;

//https://leetcode.com/problems/valid-anagram/


import java.util.Arrays;

public class ValidAnagrams {
    public static void main(String[] args) {
        String s = "rat", t = "cat";
//        System.out.println(isAnagram(s, t));
//        System.out.println(isAnagramOptimal(s, t));

        String[][] mulStringTestCase = {{"123", "400"}, {"6253", "8273"}, {"65187263", "90000"}, {"565234", "9090909"}};
        for (String[] a : mulStringTestCase) {
            System.out.println(mulString(a[0], a[1]));
        }
    }

    private static String mulString(String s1, String s2) {

        int l1 = s1.length();
        int l2 = s2.length();
        int[] result = new int[l1 + l2];
        int i = l1 - 1;
        int pf = 0;

        while (i >= 0) {
            int iVal = s1.charAt(i) - '0';
            i--;

            int j = l2 - 1;
            int carry = 0;
            int k = result.length - 1 - pf;
            while (j >= 0 || carry != 0) {
                int jVal = j >= 0 ? s2.charAt(j) - '0' : 0;
                j--;

                int prod = iVal * jVal + result[k] + carry;
                carry = prod / 10;
                result[k] = prod % 10;
                k--;
            }
            pf++;
        }

        boolean flag = false;
        StringBuilder sb = new StringBuilder();

        for (int a : result) {
            if (a == 0 && !flag) {}
            else {
                flag = true;
                sb.append(a);
            }
        }

        return sb.toString();
    }

    private static boolean isAnagramOptimal(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] charArr = new int[26];
        int i = 0;
        for (char c : s.toCharArray()) {
            charArr[c - 'a']++;
            charArr[t.charAt(i++) - 'a']--;
        }
        for (int j : charArr) {
            if (j != 0) return false;
        }
        return true;
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;
        char[] sCh = s.toCharArray();
        char[] tCh = t.toCharArray();
        Arrays.sort(sCh);
        Arrays.sort(tCh);
        return Arrays.toString(sCh).equals(Arrays.toString(tCh));

        /*
        boolean result = false;
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (Character c : s.toCharArray()) {
            if (sMap.get(c) != null) {
                sMap.put(c, 1 + sMap.getOrDefault(c, 0));
            } else {
                sMap.put(c, 1);
            }
        }
        for (Character c : t.toCharArray()) {
            if (tMap.get(c) != null) {
                tMap.put(c, 1 + tMap.getOrDefault(c, 0));
            } else {
                tMap.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> eMap : sMap.entrySet()) {
            if (tMap.containsKey(eMap.getKey())) {
                result = Objects.equals(tMap.get(eMap.getKey()), eMap.getValue());
                sb.append(result);
            } else {
                return false;
            }
        }
        return !sb.toString().contains("false");
        */
    }
}
