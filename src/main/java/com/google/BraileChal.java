package com.google;

import java.util.HashMap;
import java.util.Map;

public class BraileChal {

    public static void main(String[] args) {
        Map<Character, String> dataMap = prepareMapping();
        String inputString = "Code";
        StringBuilder sb = new StringBuilder();
        System.out.println(dataMap);
        for (char c : inputString.toCharArray()) {
            if (Character.isAlphabetic(c) && Character.isUpperCase(c)) {
                sb.append(dataMap.get('^'));
                sb.append(dataMap.get(Character.toLowerCase(c)));
            } else {
                sb.append(dataMap.get(c));
            }
        }
        System.out.println(sb);
    }

    public static Map<Character, String> prepareMapping() {
        Map<Character, String> map = new HashMap<>();
        String inputString = "The quick brown fox jumps over the lazy dog";
        String encodedString = "000001011110110010100010000000111110101001010100100100101000000000110000111010101010010111101110000000110100101010101101000000010110101001101100111100011100000000101010111001100010111010000000011110110010100010000000111000100000101011101111000000100110101010110110";
        char[] inputChar = inputString.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 0; i < inputChar.length; i++) {
            char s = inputChar[i];
            end = start + 6;
            String encStr = start >= encodedString.length() ? encodedString.substring(start - 6) : encodedString.substring(start, end);
            if (Character.isAlphabetic(s) && Character.isUpperCase(s) && !map.containsKey(s)) {
                map.put('^', encStr);
                inputChar[i] = Character.toLowerCase(s);
                start = start + 6;
                end = start + 6;
                map.put(inputChar[i], encodedString.substring(start, end));
            } else if (encStr.equals("000000")) {
                map.put(' ', encStr);
            } else {
                map.put(s, encStr);
            }
            start = end;
        }

        return map;
    }
}
