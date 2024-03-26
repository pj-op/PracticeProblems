package com.strings;

//https://www.geeksforgeeks.org/problems/find-the-n-th-character5925/1

public class FindTheNthCharacter {
    public static void main(String[] args) {
        String s = "1100";
        int r = 2, n = 3;
        System.out.println(nthCharacter(s, r, n));
    }

    private static char nthCharacter(String s, int r, int n) {
        StringBuilder sb = new StringBuilder();

        while (r > 0) {
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    sb.append("01");
                } else sb.append("10");
            }
            s = sb.toString();
            System.out.println(s);
            sb = new StringBuilder();
            r--;
        }

        return s.charAt(n);
    }
}
