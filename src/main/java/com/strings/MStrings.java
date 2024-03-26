package com.strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MStrings {
    public static void main(String[] args) {
        String s1 = "1234";
        String s2 = "304";
        System.out.println(mStr12(s1, s2));
    }

    private static String mStr12(String s1, String s2) {
        StringBuffer sb = new StringBuffer();
        int l1 = s1.length();
        int l2 = s2.length();
        int[] res = new int[l1 + l2];

        int i = l1 - 1;
        int pf = 0;
        while (i >= 0) {
            int iVal = s1.charAt(i) - '0' > 0 ? s1.charAt(i) - '0' : 0;
            i--;

            int j = l2 - 1;
            int k = res.length - 1 - pf;
            int carry = 0;
            while (j >= 0 || carry != 0) {
                int jVal = j >= 0 ? s2.charAt(j) - '0' : 0;
                j--;

                int prod = iVal * jVal + carry + res[k];
                carry = prod / 10;
                res[k] = prod % 10;

                k--;
            }
            pf++;
        }


//        System.out.println(Arrays.toString(res));

        String ans = Arrays.stream(res).mapToObj(String::valueOf).collect(Collectors.joining(""));

        return ans;
    }
}
