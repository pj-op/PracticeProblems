package com.againpractice;

public class SecondSmallestNumber {
    public static void main(String[] args) {

        int arr[] = {45, 33, 2, 19, 66, 11};
        int arr_size = arr.length;

        int first, second;

        first = second = Integer.MAX_VALUE;
        for (int i = 0; i < arr_size; i++) {
            /*
             * If current element is smaller than first then update both first and second
             */
            if (arr[i] < first) {
                second = first;
                first = arr[i];
                System.out.println("**If**");
                System.out.println(second);
                System.out.println(first);
            }

            /*
             * If arr[i] is in between first and second then update second
             */
            else if (arr[i] < second && arr[i] != first)
                System.out.println("**else If**");
            second = arr[i];

            System.out.println("Iteration completed: " + i);
        }

        System.out.println("Answer: " + second);
    }

}
