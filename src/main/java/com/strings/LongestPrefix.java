package com.strings;

//https://leetcode.com/problems/longest-common-prefix/

public class LongestPrefix {
    public static void main(String[] args) {
        String[] strs =
//                {"a"}
//                {"dog", "racecar", "car"}
                {"flower", "flow", "flight"}
//                {"reflower", "flow", "flight"}
//                {"ca", "c", "bba", "bacb", "bcb"}
                ;

        System.out.println(longestCommonPrefix1(strs));
//        System.out.println(longestCommonPrefix(strs));
//        System.out.println(longestCommonPrefixOptimize(strs));
//        System.out.println(longestCommonPrefixUsingBinarySearch(strs));
    }

    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String shortest = strs[0];
        for (String str : strs) {
            if (str.length() < shortest.length()) {
                shortest = str;
            }
        }
        for (int i = 0; i < shortest.length(); i++) {
            char c = shortest.charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != c) {
                    return shortest.substring(0, i);
                }
            }
        }
        return shortest;
    }

    public static String longestCommonPrefixOptimize(String[] strs) {

        if (strs.length < 2) return strs[0];

        int minLength = Integer.MAX_VALUE;
        for (String s : strs) {
            minLength = Math.min(minLength, s.length());
        }

        int j = 0;
        int k = 0;
        boolean match = true;

        while (j < minLength && match) {
            char c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(j) != c) {
                    match = false;
                    break;
                }
            }
            if (match) {
                k++;
            }
            j++;
        }

        return k > 0 ? strs[0].substring(0, k) : "";
    }

    public static String longestCommonPrefixUsingBinarySearch(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        int low = 1, high = strs.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (strs[mid].startsWith(prefix)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return prefix.substring(0, high + 1);
    }


}
