package com.arrays;

public class FindMountainArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;
        System.out.println();
    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        return 0;
    }
}

interface MountainArray {
    public int get(int index);

    public int length();
}