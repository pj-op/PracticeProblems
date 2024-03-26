package com.GRAPH;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String[] wordList = {"des", "der", "dfr", "dgt", "dfs"};
        String startWord = "der", targetWord = "dfs";

//        String[] wordList = {"poon", "plee", "same", "poie", "plea", "plie", "poin"};
//        String startWord = "toon", targetWord = "plea";

//        System.out.println(calculateMinimumSequenceTransformationRecap(wordList, startWord, targetWord));
//        System.out.println(printAllMinimumSubsequence(wordList, startWord, targetWord));
        System.out.println(printAllMinimumSubsequenceRecap(wordList, startWord, targetWord));
    }

    private static List<List<String>> printAllMinimumSubsequenceRecap(String[] wordList, String startWord, String targetWord) {
        List<List<String>> subSequenceList = new LinkedList<>();
        Set<String> wordsSet = new HashSet<>(List.of(wordList));
        Queue<List<String>> queue = new LinkedList<>();
        List<String> beginList = new LinkedList<>();
        List<String> usedWordList = new LinkedList<>();
        beginList.add(startWord);
        queue.add(beginList);
        usedWordList.add(startWord);
        int level = 0;

        while (!queue.isEmpty()) {
            List<String> currList = queue.poll();

            if (currList.size() > level) {
                level++;
                for (String word : usedWordList) {
                    wordsSet.remove(word);
                }
            }
            String currentWord = currList.get(currList.size() - 1);

            if (currentWord.equalsIgnoreCase(targetWord)) {
                subSequenceList.add(currList);
            }

            char[] currWordArray = currentWord.toCharArray();
            for (int i = 0; i < currWordArray.length; i++) {
                char originalWord = currWordArray[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    currWordArray[i] = j;
                    String replacedWord = String.valueOf(currWordArray);
                    if (wordsSet.contains(replacedWord)) {
                        currList.add(replacedWord);
                        List<String> tmp = new LinkedList<>(currList);
                        queue.add(tmp);
                        usedWordList.add(replacedWord);
                        currList.remove(replacedWord);
                    }
                }
                currWordArray[i] = originalWord;
            }
        }
        return subSequenceList;
    }

    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        ArrayList<ArrayList<String>> resultList = new ArrayList<>();

        Set<String> wordsSet = new HashSet<String>(Arrays.asList(wordList));
        Queue<List<String>> queue = new LinkedList<>();
        queue.add(new LinkedList<String>(Arrays.asList(startWord)));

        List<String> usedWordsList = new LinkedList<>(Arrays.asList(startWord));
        int level = 0;

        while (!queue.isEmpty()) {
            List<String> currList = queue.poll();
            if (currList.size() > level) {
                level++;
                for (String word : usedWordsList) {
                    wordsSet.remove(word);
                }
            }

            String currWord = currList.get(currList.size() - 1);

            if (currWord.equalsIgnoreCase(targetWord)) {
                resultList.add((ArrayList<String>) currList);
            }

            char[] currWordArray = currWord.toCharArray();

            for (int i = 0; i < currWordArray.length; i++) {
                char originalWord = currWordArray[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    currWordArray[i] = j;
                    String replacedWord = String.valueOf(currWordArray);
                    if (wordsSet.contains(replacedWord)) {
                        currList.add(replacedWord);
                        List<String> tmp = new ArrayList<>(currList);
                        queue.add(tmp);
                        usedWordsList.add(replacedWord);
                        currList.remove(currList.size() - 1);
                    }

                }
                currWordArray[i] = originalWord;
            }
        }


        return resultList;
    }

    private static List<List<String>> printAllMinimumSubsequence(String[] wordList, String startWord, String targetWord) {
        List<List<String>> resultList = new ArrayList<>();

        Set<String> wordsSet = new HashSet(List.of(wordList));
        Queue<List<String>> queue = new LinkedList<>();
        queue.add(new LinkedList<String>(Arrays.asList(startWord)));

        List<String> usedWordsList = new LinkedList<>(Arrays.asList(startWord));
        int level = 0;

        while (!queue.isEmpty()) {
            List<String> currList = queue.poll();
            if (currList.size() > level) {
                level++;
                for (String word : usedWordsList) {
                    wordsSet.remove(word);
                }
            }

            String currWord = currList.get(currList.size() - 1);

            if (currWord.equalsIgnoreCase(targetWord)) {
                resultList.add(currList);
            }

            char[] currWordArray = currWord.toCharArray();

            for (int i = 0; i < currWordArray.length; i++) {
                char originalWord = currWordArray[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    currWordArray[i] = j;
                    String replacedWord = String.valueOf(currWordArray);
                    if (wordsSet.contains(replacedWord)) {
                        currList.add(replacedWord);
                        List<String> tmp = new ArrayList<>(currList);
                        queue.add(tmp);
                        usedWordsList.add(replacedWord);
                        currList.remove(currList.size() - 1);
                    }

                }
                currWordArray[i] = originalWord;
            }
        }


        return resultList;
    }

    private static int calculateMinimumSequenceTransformationRecap(String[] wordList, String startWord, String targetWord) {
        Set<String> wordsSet = new HashSet<>(List.of(wordList));
        Queue<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(startWord, 1));

        while (!queue.isEmpty()) {
            WordNode currNode = queue.poll();
            String currWord = currNode.getWord();
            int steps = currNode.getSteps();

            if (currWord.equalsIgnoreCase(targetWord)) {
                return steps;
            }

            char[] currWordArray = currWord.toCharArray();
            for (int i = 0; i < currWordArray.length; i++) {
                char originalChar = currWordArray[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    currWordArray[i] = j;
                    String replacedWord = String.valueOf(currWordArray);
                    if (wordsSet.contains(replacedWord)) {
                        queue.add(new WordNode(replacedWord, steps + 1));
                        wordsSet.remove(replacedWord);
                    }
                }
                currWordArray[i] = originalChar;
            }
        }
        return 0;
    }

    private static int calculateMinimumSequenceTransformation(String[] wordList, String startWord, String targetWord) {
        Set wordsSet = new HashSet(List.of(wordList));
        Queue<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(startWord, 1));

        while (!queue.isEmpty()) {
            WordNode wordNode = queue.poll();
            String currWord = wordNode.getWord();
            int currStep = wordNode.getSteps();

            if (currWord.equalsIgnoreCase(targetWord)) return currStep;

            char[] currWordArray = currWord.toCharArray();
            for (int i = 0; i < currWordArray.length; i++) {
                char originalWord = currWordArray[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    currWordArray[i] = j;
                    String replacedWord = String.valueOf(currWordArray);
                    if (wordsSet.contains(replacedWord)) {
                        queue.add(new WordNode(replacedWord, currStep + 1));
                        wordsSet.remove(replacedWord);
                    }
                }
                currWordArray[i] = originalWord;
            }
        }
        return 0;
    }
}

class WordNode {
    private String word;
    private int steps;

    public WordNode(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }

    public String getWord() {
        return word;
    }

    public int getSteps() {
        return steps;
    }
}
