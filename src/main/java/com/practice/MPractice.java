package com.practice;

import java.math.BigInteger;

public class MPractice {

    public static void main(String[] args) {
        String a = "876487263478627346782634762378682736587364593845938485736457634856387465783645763478653784657634756378465783648756347856378468736457634875637465736457863475634756";
        String b = "8764872634786273467826347623786827365873645938459384857364576348563874657836457634786537846576347563784657836487563478563784687364576348756374657364578634756347567458374573847583748573874573485";
        String c = "1929381293819283123";

        /*System.out.println(multiplication(a, multiplication(b, c)));
        System.out.println("Multiplication Is : " + multiplication(a, b).equals((new BigInteger(a).multiply(new BigInteger(b))).toString()));
        */

        String str = "0101";
        System.out.println(makeBinaryStr(str));

    }

    private static int makeBinaryStr(String str) {
        int c1 = 0, c2 =0;

        for (int i = 0; i < str.length(); i++) {
            if(i%1==0 && str.charAt(i)=='0') c1++;
            if(i%2==0 && str.charAt(i)=='1') c1++;
            if(i%1==0 && str.charAt(i)=='1') c2++;
            if(i%2==0 && str.charAt(i)=='0') c2++;
        }

        return Math.min(c1,c2);
    }

    private static String multiplication(String a, String b) {
        StringBuilder ans = null;

        int l1 = a.length();
        int l2 = b.length();
        int[] result = new int[l1 + l2];

        int i = l1 - 1;
        int pk = 0;

        while (i >= 0) {
            int iVal = a.charAt(i) - '0';
            i--;

            int j = l2 - 1;
            int carry = 0;
            int k = result.length - 1 - pk;

            while (j >= 0 || carry != 0) {
                int jVal = j >= 0 ? b.charAt(j) - '0' : 0;
                j--;

                int prod = iVal * jVal + carry + result[k];
                carry = prod / 10;
                result[k] = prod % 10;
                k--;
            }
            pk++;
        }

        ans = new StringBuilder();
        boolean flag = false;
        for (int c : result) {
            if (c == 0 && !flag) {
            } else {
                flag = true;
                ans.append(c);
            }
        }


        return ans.toString();
    }


}
