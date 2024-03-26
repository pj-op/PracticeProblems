package com.ds;

import java.util.Arrays;

public class CreatingHashMapUsingArray {

    int[] arr;

    public CreatingHashMapUsingArray() {
        arr = new int[10_0000];
        Arrays.fill(arr, -1);
    }

    public void put(int key, int value) {
        arr[key] = value;
    }

    public int get(int key) {
        return arr[key];
    }

    public void remove(int key) {
        arr[key] = -1;
    }
}
