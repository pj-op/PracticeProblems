package com.strings;

public class PalindromCheck {
    public static void main(String[] args) {
        String testCase =
                "mbadm"
//                "abcba"
                ;
//        System.out.println(isPalindrome(testCase));
        System.out.println(minStepToMakePalindrome(testCase));
    }

    private static boolean isPalindrome(String testCase) {
        int i = 0;
        int count = 0;
        int j = testCase.length() - 1;
        if (j == 1) return true;

        while (i <= j && count < testCase.length()) {
            if (testCase.charAt(i) == testCase.charAt(j)) {
                i++;
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }
        return count == 0;
    }

    private static int minStepToMakePalindrome(String testCase) {
        int i = 0;
        int count = 0;
        int j = testCase.length() - 1;
        if (j == 1) return 0;

        while (i <= j && count < testCase.length()) {
            if (testCase.charAt(i) == testCase.charAt(j)) {
                i++;
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }
        return count;
    }
}
