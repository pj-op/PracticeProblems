package com.GRAPH;

import java.util.*;
import java.util.stream.Stream;

public class WordLadder1 {
    public static void main(String[] args) {
//        String[] wordList = {"des", "der", "dfr", "dgt", "dfs"};
//        String startWord = "der", targetWord = "dfs";

        String[] wordList = {"poon", "plee", "same", "poie", "plea", "plie", "poin"};
        String startWord = "toon", targetWord = "plea";


        findPossibilityInWordList(wordList, startWord, targetWord);

    }

    private static void findPossibilityInWordList(String[] wordList, String startWord, String targetWord) {
        int ans = 0;
        Set<String> wordsSet = new HashSet<>();
        Collections.addAll(wordsSet, wordList);
        char[] startWordCharArray = startWord.toCharArray();
        for (int i = 0; i < startWordCharArray.length; i++) {
            char originalWord = startWordCharArray[i];
            for (int j = 'a'; j <= 'z'; j++) {
                startWordCharArray[i] = (char) j;
//                System.out.print(String.valueOf(startWordCharArray) + ",");
                String calcWord = String.valueOf(startWordCharArray);
                if (wordsSet.contains(calcWord)) {
                    if (calcWord.equalsIgnoreCase(targetWord)) {
                        break;
                    }
                    ans++;
                    wordsSet.remove(calcWord);
                }
            }
//            System.out.println();
            startWordCharArray[i] = originalWord;
        }
        System.out.println(ans);

    }
}
