package com.strings;

public class ReverseWordsStringIII {
    public static void main(String[] args) {
        String sentence = "Let's take LeetCode contest";
        System.out.println(reverseWords(sentence));
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        for (String str : s.split(" ")) {
            sb.append(reverseIndividualWord(str));
        }

        return sb.toString().strip();
    }

    private static String reverseIndividualWord(String word) {
        int i = 0;
        int j = word.length() - 1;
        char[] charArray = word.toCharArray();

        while (i <= j) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(charArray).concat(" ");
    }
}
