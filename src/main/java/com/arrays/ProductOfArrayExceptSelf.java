package com.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(num)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] prefixProd = new int[n];
        int[] postfixProd = new int[n];

        prefixProd[0] = nums[0];
        for (int i = 1; i < prefixProd.length; i++) {
            prefixProd[i] = nums[i] * prefixProd[i - 1];
        }
        postfixProd[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            postfixProd[i] = nums[i] * postfixProd[i + 1];
        }

        for (int i = 0; i < n; i++) {
            if (i > 0 && i < n - 1) ans[i] = postfixProd[i + 1] * prefixProd[i - 1];
            else if (i == 0) ans[i] = postfixProd[i + 1];
            else if (i == n - 1) ans[i] = prefixProd[i - 1];
        }
        return ans;

    }
}
