package com.strings;
public class RemoveColoredPiecesBothNeighSameColor {
    public static void main(String[] args) {
        String colors =
                "ABBBBBBBAAA"
//                "AAABABB"
                ;
        System.out.println(winnerOfGameOptimal(colors));
    }
    public static boolean winnerOfGame(String colors) {
        if (colors.length() < 3) return false;
        int i = 0;
        boolean ans = false;

        while (i <= colors.length()) {
            if (i % 2 == 0 && colors.contains("AAA")) {
                System.out.println("Alice Turn");
                colors = colors.replaceFirst(colors.substring(colors.indexOf("AAA"), colors.indexOf("AAA") + 3), "AA");
                System.out.println(colors);
                ans = true;
            }
            if (i % 2 != 0 && colors.contains("BBB")) {
                System.out.println("Bob Turn");
                colors = colors.replaceFirst(colors.substring(colors.indexOf("BBB"), colors.indexOf("BBB") + 3), "BB");
                System.out.println(colors);
                ans = false;
            }
            i++;
        }
        return ans;
    }
    public static boolean winnerOfGameOptimal(String colors) {
        int alice = 0;
        int bob = 0;
        for (int i = 1; i < colors.length(); i++) {
            if ((i + 1) < colors.length() && colors.charAt(i - 1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A') alice++;
                if (colors.charAt(i) == 'B') bob++;
            }
        }
        return alice - bob >= 1;
    }
}
