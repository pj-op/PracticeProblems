package com.strings;

public class CheckiftheSentenceIsPangram {
    public static void main(String[] args) {
        String sentence = "leetcode";
        System.out.println(checkIfPangram(sentence));
    }

    private static boolean checkIfPangram(String sentence) {
        boolean[] alpha = new boolean[26];

        for (char c : sentence.toCharArray()) {
            alpha[c - 'a'] = true;
        }

        for (boolean isPresent : alpha) {
            if (!isPresent) {
                return false;
            }
        }
        return true;
    }
}
