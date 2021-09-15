package com.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class MoveZeros {
    public static void main(String[] args) {
//        1. Move Zeros - Accepted
        int[] arr = {0, 1, 0, 3, 12, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 2};
//        moveZero(arr);

//        2. Two Sum II - Input array is sorted - Accepted
        int[] num = {2, 3, 4};
        int target = 6;
//        System.out.println(Arrays.toString(twoSum(num, target)));

//        3. Reverse String Array - Accepted
        String strArr[] = {"h", "e", "l", "l", "o"};
//        System.out.println(Arrays.toString(getReverseArray(strArr)));

//        4. Reverse Words in a String III
        String str = "Let's take LeetCode contest";
//        System.out.println(reverseWords(str));

//        5. Check intersection if the array
        int[] nums1 = {1, 3, 4, 5, 8}, nums2 = {2, 4, 5, 8, 3};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));

    }

    private static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect(nums2, nums1);

        int i = 0, j = 0, result[] = new int[Math.min(nums1.length, nums2.length)];

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result[i] = nums1[i];
                i++;
            }
            j++;
        }

        return result;
    }

    private static String reverseWords(String str) {
        StringBuilder sb = new StringBuilder();
        String inputString = str.trim().replaceAll("( )+", " ");

        for (String s : inputString.split(" ")) {
            sb.append(getReverseArray(s.toCharArray())).append(" ");
        }


//        System.out.println(inputString);

        return sb.toString();
    }

    private static char[] getReverseArray(char[] strArr) {
        int i = 0, j = strArr.length - 1;

        while (i < j) {
            char temp = strArr[i];
            strArr[i] = strArr[j];
            strArr[j] = temp;
            i++;
            j--;
        }

        return strArr;
    }

    private static int[] twoSum(int[] num, int target) {
        Map<Integer, Integer> complementMap = new HashMap<>();

        for (int i = 0; i < num.length; i++) {
            if (complementMap.containsKey(num[i])) {
                return new int[]{complementMap.get(num[i]), i + 1};
            } else {
                complementMap.put(target - num[i], i + 1);
            }
        }
        System.out.println(complementMap);


        return new int[]{};
    }

    private static void moveZero(int[] arr) {
        int i = 0, j = 0;

        while (i < arr.length && j < arr.length) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
            i++;
        }

        while (j < arr.length) {
            arr[j] = 0;
            j++;
        }


        System.out.println(Arrays.toString(arr));

    }
}
