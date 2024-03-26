package com.strings;

//https://leetcode.com/problems/add-digits/submissions/ ACCEPTED

public class AddDigits {
    public static void main(String[] args) {
        int num = 886996;
//        System.out.println(addDigits(num));
        System.out.println(alternateDigitSum(num));
    }

    public static int addDigits(int num) {
        int sum = 0;
        int rem = 0;
        while (num > 0) {
            rem = num % 10;
            sum = sum + rem;
            num = num / 10;
        }
        return sum >= 10 ? addDigits(sum) : sum;
    }

    public static int alternateDigitSum(int num) {
        int sum = 0;
        int rem = 0;
        boolean flag = false;
        while (num > 0) {
            rem = num % 10;
            if (!flag) {
                sum = sum + rem;
                flag = true;
            } else {
                sum = rem - sum;
            }
            num = num / 10;
        }
        return sum;
    }
}
