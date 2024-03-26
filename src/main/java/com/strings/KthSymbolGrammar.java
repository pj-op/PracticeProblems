package com.strings;

public class KthSymbolGrammar {
    public static void main(String[] args) {
        int n = 3, k = 1;
//        System.out.println(kthGrammar(n, k));
        System.out.println(Integer.toBinaryString(16) + "==" + Integer.bitCount(16));
    }

    public static int kthGrammar(int n, int k) {
        String ans = "0";
        String temp1 = "";
        String temp2 = "";

        for (int i = 2; i <= n; i++) {
            if (ans.contains("0")) {
                String s1 = ans.replaceAll("0", "01");
                String temp = ans.contains("1") ? ans.replaceAll("1", "") : "";
                temp1 = s1 + temp;
            }
            if (ans.contains("1")) {
                String s2 = ans.replaceAll("1", "10");
                String temp = ans.contains("0") ? ans.replaceAll("0", "") : "";
                temp2 = s2 + temp;
            }

            ans = temp1 + temp2;
        }


        System.out.println(ans);
        return 0;
    }
}
