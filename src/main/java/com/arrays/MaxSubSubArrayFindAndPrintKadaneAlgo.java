package com.arrays;

public class MaxSubSubArrayFindAndPrintKadaneAlgo {
    public static void main(String[] args) {
        int[] arr =
                {-2, -1};
//                {5, 4, -1, 7, 8};
//                {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(findAndPrintMaxSumSubArrayDC(arr));
//        System.out.println(Arrays.toString(findAndPrintMaxSumSubArrayII(arr)));
//        System.out.println(Arrays.toString(findAndPrintBruteForceII(arr)));
    }

    private static int findAndPrintMaxSumSubArrayDC(int[] arr) {
        return findAndPrintMaxSumSubArrayDC(arr, 0, arr.length - 1);
    }

    private static int findAndPrintMaxSumSubArrayDC(int[] arr, int low, int high) {
        if (low == high) return arr[low];
        int mid = low + (high - low) / 2;

        int leftMaxSum = findAndPrintMaxSumSubArrayDC(arr, low, mid);
        int rightMaxSum = findAndPrintMaxSumSubArrayDC(arr, mid + 1, high);

        int lSum = Integer.MIN_VALUE;
        int rSum = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;

        for (int i = mid; i >= 0; i--) {
            sum += arr[i];
            if (sum > lSum) {
                lSum = sum;
            }
        }
        sum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            if (sum > rSum) {
                rSum = sum;
            }
        }
        return Math.max(lSum + rSum, Math.max(leftMaxSum, rightMaxSum));
    }

    private static int[] findAndPrintMaxSumSubArrayII(int[] arr) {

        int sum = 0;
        int ansJ = -1;
        int ansI = -1;
        int startI = -1;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) {
                startI = i;
            }
            sum += arr[i];

            if (sum < 0) {
                sum = 0;
            }

            if (sum > maxSum) {
                maxSum = sum;
                ansI = startI;
                ansJ = i;
            }

        }


        int[] ans = new int[ansJ - ansI + 1];
        int idx = 0;
        for (int i = ansI; i <= ansJ; i++) {
            ans[idx++] = arr[i];
        }

        return ans;
    }

    private static int[] findAndPrintBruteForceII(int[] arr) {
        int ansJ = -1;
        int ansI = -1;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    ansI = i;
                    ansJ = j;
                }
            }
        }

        int[] ans = new int[ansJ - ansI + 1];
        int idx = 0;
        for (int i = ansI; i <= ansJ; i++) {
            ans[idx++] = arr[i];
        }
        return ans;
    }

    private static int[] findAndPrintMaxSumSubArray(int[] arr) {
        int sum = 0;
        int ansJ = -1;
        int ansI = -1;
        int startI = -1;

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) startI = i;
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
            }
            if (sum > maxSum) {
                maxSum = sum;
                ansI = startI;
                ansJ = i;
            }
        }
        int[] ans = new int[ansJ - ansI + 1];
        int j = 0;
        for (int i = ansI; i <= ansJ; i++) {
            ans[j++] = arr[i];
        }
        return ans;
    }

    private static int[] findAndPrintBruteForce(int[] arr) {
        int ansI = -1;
        int ansJ = -1;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum > maxSum) {
                    maxSum = sum;
                    ansI = i;
                    ansJ = j;
                }
            }
        }

        int[] ans = new int[ansJ - ansI + 1];
        int j = 0;
        for (int i = ansI; i <= ansJ; i++) {
            ans[j++] = arr[i];
        }
        return ans;
    }
}
