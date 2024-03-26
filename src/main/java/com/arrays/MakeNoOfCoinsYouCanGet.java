package com.arrays;

import java.util.Arrays;

public class MakeNoOfCoinsYouCanGet {
    public static void main(String[] args) {
        int[] piles =
//                {2, 4, 1, 2, 7, 8};
                {9, 8, 7, 6, 5, 1, 2, 3, 4};
        System.out.println(maxCoins(piles));
    }

    public static int maxCoins(int[] piles) {
        int k = 0;
        int ans = 0;
        int n = piles.length / 3;

        Arrays.sort(piles);

        for (int i = piles.length - 2; i >= 0; i -= 2) {
            ans += piles[i];
            k++;
            if (k == n) break;
        }

        return ans;
    }

}
