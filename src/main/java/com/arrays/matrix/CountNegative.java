package com.arrays.matrix;

public class CountNegative {
    public static void main(String[] args) {
        int[][] grid = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };

        int[] a = {9, 5, 2, 1};
//        System.out.println(binarySearch(1, a));

        System.out.println(countNegatives(grid));

    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] < 0) {
                    count += ints.length - j;
                    break;
                }
            }
        }
        return count;
    }

    public static int binarySearch(int negElement, int[] arr) {
        int lowIndex = 0;
        int midIndex = 0;
        int highIndex = arr.length - 1;

        while (lowIndex <= highIndex) {
            midIndex = (highIndex + lowIndex) / 2;
            if (arr[midIndex] == negElement) return midIndex;
            if (arr[midIndex] > negElement) lowIndex = midIndex + 1;
            else highIndex = midIndex - 1;
        }
        return midIndex;
    }
}
