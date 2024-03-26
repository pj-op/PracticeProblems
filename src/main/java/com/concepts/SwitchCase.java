package com.concepts;

public class SwitchCase {
    public static void main(String[] args) {
        String s = "JANUARY";

        switch (s) {
            case "FEB" -> System.out.println("FEB");
            case "JANUARY" -> System.out.println("JANUARY");
            default -> System.out.println("Nothing");
        }

    }
}
