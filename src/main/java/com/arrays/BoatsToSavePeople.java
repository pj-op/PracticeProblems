package com.arrays;

//https://leetcode.com/problems/boats-to-save-people/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BoatsToSavePeople {
    public static void main(String[] args) {
//        int[] people = {1, 2}; int limit = 3;
        int[] people = {3, 2, 2, 1};
        int limit = 3;
//        int [] people = {3,5,3,4}; limit = 5;

        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        int result = 0;
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;

        while (i <= j) {
            int sum = people[i] + people[j];
            if (sum <= limit) {
                result++;
                i++;
                j--;
            } else {
                result++;
                j--;
            }
        }
        return result;
    }
}
