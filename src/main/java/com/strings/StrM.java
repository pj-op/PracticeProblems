package com.strings;

public class StrM {
    public static void main(String[] args) {
        String s1 = "12653615263";
        String s2 = "4";
//        System.out.println(mulStringsAg(s1, s2));
//        String str = "2[a3[b]]";
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    private static String mulStringsAg(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[] res = new int[l1 + l2];

        int pf = 0;
        int i = l1 - 1;

        while (i >= 0) {
            int iVal = s1.charAt(i) - '0';
            i--;

            int carry = 0;
            int j = l2 - 1;
            int k = res.length - 1 - pf;

            while (j >= 0 || carry != 0) {
                int jVal = j >= 0 ? s2.charAt(j) - '0' : 0;
                j--;

                int prod = iVal * jVal + carry + res[k];
                res[k] = prod % 10;
                carry = prod / 10;
                k--;
            }
            pf++;
        }
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int a : res) {
            if (a == 0 && !flag) continue;
            else {
                flag = true;
                sb.append(a);
            }
        }
        return sb.toString();
    }

}
