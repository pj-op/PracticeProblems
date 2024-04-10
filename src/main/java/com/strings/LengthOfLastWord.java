package com.strings;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s =
                "   fly me   to   the moon  "
                //"luffy is still joyboy"
                ;
        System.out.println(lengthOfLastWordII(s));
    }

    private static int lengthOfLastWordII(String s) {
        int j = 0;
        int n = s.length();
        int i = n - 1;

        while (i >= 0) {
            if (Character.isAlphabetic(s.charAt(i))) {
                System.out.println(s.charAt(i));
                break;
            }
            i--;
        }
        j = i;
        while (i >= 0) {
            if (i - 1 >= 0 && !Character.isAlphabetic(s.charAt(i - 1))) {
                System.out.println(s.charAt(i));
                break;
            }
            i--;
        }


        return j - i + 1;
    }

    private static int lengthOfLastWord(String s) {
        String[] arr = s.trim().replaceAll("( )+", " ").split(" ");
        return arr[arr.length - 1].length();
    }
}
