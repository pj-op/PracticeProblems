package com.arrays;

import java.util.Arrays;

public class LongestObstacleEachPosition {
    public static void main(String[] args) {
        int[] testCase = {1, 2, 3, 2};
        System.out.println(Arrays.toString(longestObstacleCourseAtEachPosition(testCase)));
    }

    public static int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int inputArrayLength = obstacles.length;
        int length = 0;
        int[] result = new int[inputArrayLength];
        int[] arr2 = new int[inputArrayLength];


        for (int i = 0; i < inputArrayLength; ++i) {
            int left = 0;
            int right = length;

            while (left < right) {
                int mid = (left + right) / 2;
                if (arr2[mid] <= obstacles[i]) left = mid + 1;
                else right = mid;
            }

            result[i] = left + 1;
            if (length == left) length++;
            arr2[left] = obstacles[i];
        }

        return result;
    }
}
