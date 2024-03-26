package com.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringtoIntegeratoi {
    public static void main(String[] args) {
        String s =
//                "4193 with words"
//                "   -42"
                "words and 987";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        String ans = "";
        if (!(Character.isDigit(s.charAt(0)) || s.charAt(0) == '-' || s.charAt(0) == '+' || s.charAt(0) == ' '))
            return 0;
        // Necessary to provide the parenthesis to capture the result
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            ans = matcher.group();
        }
        if (s.indexOf(ans) - 1 >= 0 && s.charAt(s.indexOf(ans) - 1) == '-') ans = "-" + ans;
        return Integer.parseInt(ans) > Integer.MAX_VALUE ? Integer.MAX_VALUE : Integer.parseInt(ans) < Integer.MIN_VALUE ? Integer.MIN_VALUE : Integer.parseInt(ans);
    }
}
