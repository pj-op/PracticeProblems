package com.strings;

public class CheckIfTwoStringArraysEquivalent {
    public static void main(String[] args) {
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqualBruteForce(word1, word2));
    }

    public static boolean arrayStringsAreEqualBruteForce(String[] word1, String[] word2) {
        StringBuilder firstString = new StringBuilder();
        StringBuilder secondString = new StringBuilder();

        for (String word : word1) {
            firstString.append(word);
        }
        for (String word : word2) {
            secondString.append(word);
        }
        return firstString.compareTo(secondString) == 0;
    }
}
