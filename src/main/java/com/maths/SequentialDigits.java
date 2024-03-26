package com.maths;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public static void main(String[] args) {
        int low = 1000, high = 13000;
        System.out.println(sequentialDigitsAg(low, high));
    }

    private static List<Integer> sequentialDigitsAg(int low, int high) {
        String allNums = "123456789";

        int n = allNums.length();
        int nLow = String.valueOf(low).length();
        int nHigh = String.valueOf(high).length();

        List<Integer> ans = new ArrayList<>();

        for (int i = nLow; i <= nHigh; i++) {
            for (int j = 0; j + i <= n; j++) {
                String str = allNums.substring(j, j + i);
                int num = Integer.parseInt(str);
                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        return ans;

    }

    public static List<Integer> sequentialDigits(int low, int high) {

        String allNums = "123456789";
        List<Integer> ans = new ArrayList<>();

        int nLow = String.valueOf(low).length();
        int nHigh = String.valueOf(high).length();

        for (int i = nLow; i <= nHigh; i++) {
            for (int j = 0; j < allNums.length(); j++) {
                if (j + i <= allNums.length()) {
                    int num = Integer.parseInt(allNums.substring(j, j + i));
                    if (num >= low && num <= high) {
                        ans.add(num);
                    }
                }
            }
        }
        return ans;
    }
}
