package com.strings;

public class CustomSortString {
    public static void main(String[] args) {
        String order = "cba";
        String s = "abcdduu";
        System.out.println(customSortString(order, s));
    }

    private static String customSortString(String order, String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (freq[c - 'a'] > 0) {
                res.append(c);
                freq[c - 'a']--;
            }
        }

        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                res.append((char) (i + 'a'));
                freq[i]--;
            }
        }

        return res.toString();

    }
}
