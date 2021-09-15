package com.Strings;

public class MulString {
    public static void main(String[] args) {
        String s1 = "123123123123123123123123123123123123123123435435647647568678678653423234";
        String s2 = "123123123123123123123123123435435647647568";
        System.out.println(mutiplyString(s1, s2));
    }

    private static String mutiplyString(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int pf = 0;
        int l1 = s1.length();
        int l2 = s2.length();
        int result[] = new int[l1 + l2];

        int i = l1 - 1;
        while (i >= 0) {
            int iVal = i >= 0 ? s1.charAt(i) - '0' : 0;
            i--;

            int j = l2 - 1;
            carry = 0;
            int k = result.length - 1 - pf;
            while (j >= 0 || carry != 0) {
                int jVal = j >= 0 ? s2.charAt(j) - '0' : 0;
                j--;

                int prod = iVal * jVal + carry + result[k];
                result[k] = prod % 10;
                carry = prod / 10;
                k--;
            }
            pf++;
        }

        boolean flag = false;

        for (int num : result) {
            if (num == 0 && flag == false) {
                continue;
            } else {
                flag = true;
                sb = sb.append(num);
            }
        }

        return sb.toString();
    }
}
