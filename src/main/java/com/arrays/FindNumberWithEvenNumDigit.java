package com.arrays;

public class FindNumberWithEvenNumDigit {
    public static void main(String[] args) {
        int[] nums =
                //{12, 345, 2, 6, 7896}
                {555, 901, 482, 1771}
                ;
        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int j : nums) {
            int num = j;
            int numLength = 0;
            while (num > 0) {
                num = num / 10;
                numLength++;
            }
            if (numLength % 2 == 0) count++;
        }

        return count;
    }
}
