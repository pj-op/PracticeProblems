package com.array;

public class HouseRobber {
    public static void main(String[] args) {
        int arr[] = {1, 3, 1};
        System.out.println(rob(arr));
    }

    private static int rob(int[] arr) {
        if (arr.length < 2) return arr[0];
        if (arr.length < 3) return Math.max(arr[0], arr[1]);
        int total1 = 0, total2 = 0;
        for (int i = 0; 2 * i < arr.length; i++) {
            int num = arr[2 * i];
            total1 = total1 + num;
        }
        for (int i = 0; 2 * i + 1 < arr.length; i++) {
            int num = arr[2 * i + 1];
            total2 = total2 + num;
        }
        return Math.max(total1, total2);
    }
}
