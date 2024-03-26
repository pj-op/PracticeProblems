package com.strings;

public class MergeStringAlternate {
    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqr";
//        String word1 = "ab", word2 = "pqrs";
//        String word1 = "abcd", word2 = "pq";
        System.out.println(mergeAlternatively(word1, word2));
    }

    private static String mergeAlternatively(String word1, String word2) {
        int ansWordLength = word1.length() + word2.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ansWordLength; i++) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }

}
