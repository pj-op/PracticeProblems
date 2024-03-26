package com.strings;

public class CheckPalindromeFormation {
    public static void main(String[] args) {
        String a = "xbdef", b = "xecab";
//        System.out.println(checkPalindromeFormation(a, b));
        String check = "abcdcba";
        System.out.println(checkIsPalindrome(check));
    }

    private static boolean checkPalindromeFormation(String a, String b) {
        return false;
    }

    private static boolean checkIsPalindrome(String check) {
        int l = 0, r = check.length() - 1;
        while (l < r) {
            if (check.charAt(l++) != check.charAt(r--)) return false;
        }
        return true;
    }

}
