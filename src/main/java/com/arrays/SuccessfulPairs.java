package com.arrays;

//https://leetcode.com/problems/successful-pairs-of-spells-and-potions/

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;

public class SuccessfulPairs {
    public static void main(String[] args) {
        /*
            Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
            Output: [4,0,3]
            Explanation:
            - 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
            - 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
            - 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
            Thus, [4,0,3] is returned.
         */

        int[] spells = {5, 1, 3}, potions = {1, 2, 3, 4, 5};
        int success = 7;
//        int[] spells = {3, 1, 2}, potions = {8, 5, 8}; int success = 16;
//        int[] spells = {5, 0, 3}, potions = {1, 2, 3, 4, 5};int success = 7;


        System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
        System.out.println(Arrays.toString(successfulPairsWithBinary(spells, potions, success)));

    }

    private static int[] successfulPairsWithBinary(int[] spells, int[] potions, int success) {
        int[] ans = new int[spells.length];
        int m = potions.length;
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            int left = 0;
            int right = m - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                long product = (long) spells[i] * potions[mid];
                if (product >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = m - left;
        }
        return ans;
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length * potions.length];
        Arrays.fill(result, -1);
        Arrays.sort(potions);
        int count = 0;
        int jPosition = 0;

        for (int i = 0; i < spells.length; i++) {
            for (int j = 0; j < potions.length; j++) {
                if (potions[j] >= ceil((double) success / spells[i])) {
                    count++;
                    jPosition = j;
                    break;
                }
            }
//            System.out.println("count: " + count + " jPosition: " + jPosition);
            result[i] = count > 0 ? (count + potions.length - 1 - jPosition) : 0;
            count = 0;
        }

        return Arrays.stream(result).filter(x -> x != -1).toArray();
    }
}
