package com.concepts.encodingAlgo;

import java.util.Base64;

public class TestBase64 {
    public static void main(String[] args) {
        System.out.println(decodedString(args[0]));
    }

    private static String decodedString(String encodedString) {
        return new String(Base64.getDecoder().decode(encodedString));
    }
}
