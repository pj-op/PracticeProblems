package com.againpractice;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        String a1 = "aaca";
        String a2 = "aaca";

        char[] c1 = a1.toCharArray();
        char[] c2 = a2.toCharArray();

        Arrays.sort(c2);
        Arrays.sort(c1);

        boolean result = String.valueOf(c2).equals(String.valueOf(c1)) ? true : false;

//        System.out.println(result);

        int a[] = {-11, -8, -8, 0, 12, 25, 413};
        int num = 7;

//        System.out.println(findNumIndexInSortedArray(a, num));

        /*
         * RunLength Encoding
         * */
        String str = "aaabbbnnjjkkbbccsssaa";

//        System.out.println(getRunLengthEncoding(str));

        /*
         * Runlength Decoding
         *
         */
        String encodedStr = "a3b3n2j2k2b2c2s3a2";

        System.out.println(getRunLengthDecoding(encodedStr).equals(str));

    }

    private static int findNumIndexInSortedArray(int arr[], int num) {

        int low = 0, high = arr.length;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == num) return mid;
            else if (arr[mid] > num) high = mid - 1;
            else if (arr[mid] < num) low = mid + 1;
            else return -1;
        }

        return -1;
    }

    private static String getRunLengthEncoding(String str) {
        StringBuffer sb = new StringBuffer();
        int i = 0, j = 0;

        while (i < str.length() && j < str.length()) {

            sb.append(str.charAt(i));
            while (j < str.length() && (str.charAt(i) == str.charAt(j))) {
                j++;
            }
            int diff = j - i;
            sb.append(diff);
            i = j;
        }

        return sb.toString();
    }

    private static String getRunLengthDecoding(String str) {
        StringBuffer result = new StringBuffer();
        int i = 0;
        char s = '0';
        while (i < str.length()) {

            if (i % 2 == 0) {
                s = str.charAt(i);
            } else {
                int rep = str.charAt(i) - '0';
                while (rep != 0) {
                    result.append(s);
                    rep--;
                }
            }
            i++;
        }

        return result.toString();
    }
}
