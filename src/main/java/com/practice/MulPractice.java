package com.practice;

public class MulPractice {

    public static void main(String[] args) {
        String s1 = "140";
        String s2 = "32";
        System.out.print(multiplicationOfTwoString(s1, s2));

    }

    private static String multiplicationOfTwoString(String s1, String s2) {

        int l1 = s1.length();
        int l2 = s2.length();

        int result[] = new int[l1 + l2];

        int i = l1 - 1;
        int pf = 0;
        while (i >= 0) {
            int iVal = i >= 0 ? s1.charAt(i) - '0' : 0;
            i--;

            int j = l2 - 1;
            int k = result.length - 1 - pf;
            int carry = 0;
            while (j >= 0 || carry != 0) {
                int jVal = j >= 0 ? s2.charAt(j) - '0' : 0;
                j--;

                int prod = iVal * jVal + carry + result[k];
                carry = prod / 10;
                result[k] = prod % 10;
                k--;
            }
            pf++;
        }
        StringBuffer sb = new StringBuffer();
        boolean flag = false;

        for (int a : result) {
            if (a == 0 && !flag) {
                continue;
            } else {
                flag = true;
                sb.append(a);
            }
        }

        return sb.toString();
    }

}
