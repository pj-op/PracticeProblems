package com.strings;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CalFreqMap {
    public static void main(String[] args) {
        String str = "xiyomy";
        System.out.println(frequencyMapAg(str));
        System.out.println(frequencyMapOptimal(str));
    }

    private static Map<Character, Integer> frequencyMapAg(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> freqMap = new HashMap<>();
        IntStream.range(0, chars.length).forEach(i -> freqMap.put(chars[i], freqMap.getOrDefault(chars[i], 0) + 1));
        return freqMap;
    }

    private static Map<Character, Integer> frequencyMapOptimal(String str) {
        int[] alphabetArray = new int[26];
        for (char c : str.toCharArray()) {
            alphabetArray[c - 'a']++;
        }
        Map<Character, Integer> map = new HashMap<>();
        IntStream.range(0, alphabetArray.length).filter(i -> alphabetArray[i] != 0).forEach(i -> map.put((char) ('a' + i), alphabetArray[i]));
        return map;
    }

    private static Map<Character, Integer> frequencyMap(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (freqMap.containsKey(c)) {
                freqMap.put(c, freqMap.getOrDefault(c, 1) + 1);
            } else {
                freqMap.put(c, 1);
            }
        }
        return freqMap;
    }
}
