package com.strings;

import java.util.Stack;

public class Dota2 {
    public static void main(String[] args) {
        String senate =
//                "RD"
//                "RDD"
                "DDRRR";
        System.out.println(predictPartyVictoryOptimal(senate));
    }

    public static String predictPartyVictory(String senate) {
        Stack<Character> stack = new Stack<>();

        for (char c : senate.toCharArray()) {
            if (!stack.isEmpty() && c != stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? senate.charAt(0) == 'R' ? "Radiant" : "Dire" : (stack.peek() == 'R' ? "Radiant" : "Dire");
    }

    public static String predictPartyVictoryOptimal(String senate) {

        boolean r = true;
        boolean d = true;
        char[] senates = senate.toCharArray();
        int flag = 0;

        while (r && d) {
            r = false;
            d = false;

            for (int i = 0; i < senates.length; i++) {
                if (senates[i] == 'R') {
                    if (flag < 0) {
                        senates[i] = 0;
                    } else {
                        r = true;
                    }
                    flag++;
                } else if (senates[i] == 'D') {
                    if (flag > 0) {
                        senates[i] = 0;
                    } else {
                        d = true;
                    }
                    flag--;
                }
            }
        }

        return r ? "Radiant" : "Dire";
    }

}
