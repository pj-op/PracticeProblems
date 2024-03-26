package com.arrays;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';
        System.out.println(nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int[] al = new int[26];
        for (char c : letters) al[c - 'a']++;
        int num = IntStream.range(target - 'a', al.length).filter(x -> al[x] == 1).findFirst().orElse(-1);
        return num == -1 ? letters[0] : (char) (num + 'a');
    }
}

