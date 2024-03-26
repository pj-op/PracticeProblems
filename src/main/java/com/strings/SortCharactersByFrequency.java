package com.strings;

import java.util.*;
import java.util.stream.Collectors;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(frequencySortUsingSorting(s));
    }

    private static String frequencySortUsingSorting(String s) {
        CharFreq[] freq = new CharFreq[123];
        for (char c : s.toCharArray()) {
            int index = c - 'A';
            if (freq[index] != null) {
                freq[index].setFreq(freq[index].getFreq() + 1);
                freq[index].setC(freq[index].getC());
            } else freq[index] = new CharFreq(c, 1);
        }
        List<CharFreq> list = Arrays.stream(freq)
                .filter(Objects::nonNull)
                .sorted((a, b) -> Integer.compare(b.freq, a.freq))
                .toList();

        StringBuilder sb = new StringBuilder();
        for (CharFreq charFreq : list) {
            int rep = charFreq.getFreq();
            while (rep > 0) {
                sb.append(charFreq.getC());
                rep--;
            }
        }
        return sb.toString();
    }

    public static String frequencySort(String s) {
        var output = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .toList();

        StringBuilder ans = new StringBuilder();
        for (Map.Entry<String, Long> entry : output) {
            String k = entry.getKey();
            long rep = entry.getValue();
            while (rep > 0) {
                ans.append(k);
                rep--;
            }
        }

        return ans.reverse().toString();
    }
}

class CharFreq {
    char c;
    int freq;

    public CharFreq(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    @Override
    public String toString() {
        return "CharFreq{" +
                "c=" + c +
                ", freq=" + freq +
                '}';
    }
}