package com.strings;

public class NumberStepsReduceNumberBinaryRepresentationOne {
    public static void main(String[] args) {
        String s = "1111111111000000000000000111111";
        System.out.println(numSteps(s));
    }

    private static int numSteps(String s) {
        int ans = 0;
        StringBuilder sb = new StringBuilder(s);

        while (!sb.toString().equals("1")) {
            if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == '0') {
                sb.deleteCharAt(sb.length() - 1);
                ans++;
            } else if (!sb.isEmpty() && sb.length() >= 2) {
                sb.setCharAt(sb.length() - 1, '0');
                sb.setCharAt(sb.length() - 2, '1');
                ans++;
            }
        }
        return ans;
    }
}
