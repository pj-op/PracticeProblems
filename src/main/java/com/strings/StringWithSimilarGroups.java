package com.strings;

import java.util.HashSet;
import java.util.Set;

public class StringWithSimilarGroups {
    public static void main(String[] args) {
        String[] strs =
//                {"omv", "ovm"}
//                {"tars", "rats", "arts", "star"}
                {"abc", "abc"}
                ;
        System.out.println(numSimilarGroups(strs));
    }

    public static int numSimilarGroups(String[] strs) {
        int result = 0;
        Set<String> visited = new HashSet<>();

        for (String str : strs) {
            if (!visited.contains(str)) {
                dfs(str, visited, strs);
                result++;
            }
        }
        return result;
    }

    private static void dfs(String word, Set<String> visited, String[] strs) {
        if (visited.contains(word)) return;
        visited.add(word);
        for (String str : strs) {
            if (isSimilar(word, str)) {
                dfs(str, visited, strs);
            }
        }
    }

    private static boolean isSimilar(String str, String str1) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str1.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
            }
        }
        return count == 2;
    }
}
