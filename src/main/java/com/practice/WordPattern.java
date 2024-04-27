package com.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class WordPattern {

    public static void main(String[] args) {
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        if (pattern.length() == 0 || s.length() == 0) return false;
        if (pattern.length() == 1 && s.length() == 1) return true;
        if (pattern.split("").length != s.split(" ").length) return false;

        Map<String, String> dataMap = new HashMap<>();
        Map<String, String> dataMap2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            dataMap.put(pattern.split("")[i], s.split(" ")[i]);
            dataMap2.put(s.split(" ")[i], pattern.split("")[i]);
        }
        boolean result = false;

        for (int j = 0; j < pattern.length(); j++) {
            if (dataMap.containsKey(pattern.split("")[j])) {
                if (!dataMap.get(pattern.split("")[j]).equals(s.split(" ")[j])) {
                    result = false;
                } else {
                    result = true;
                }
            }
            if (dataMap2.containsKey(s.split(" ")[j])) {
                if (!dataMap2.get(s.split(" ")[j]).equals(pattern.split("")[j])) {
                    result = result && false;
                } else {
                    result = result && true;
                }
            }

        }

        System.out.println(Stream.of(dataMap2).count());
        System.out.println(Stream.of(dataMap).count());

        return result;
    }
}
