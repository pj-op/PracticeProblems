package com.oops;

import com.sun.source.tree.BreakTree;

public class SmallestNumberInRoatatedSortedArray {
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 5, 1};
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int n = arr.length;
        int mid = 0;

        while(low<=high){
            mid = (low+high)/2;

            int prev = (mid - 1 + n)%n;
            int next = (mid+1)%n;

            if(arr[low]<=arr[high]) return arr[low];

            else if(arr[mid]<=arr[prev] && arr[mid]<=arr[next]){
                return arr[mid];
            }

            if(arr[mid]>=arr[low]){
                low = mid + 1;
            }
            else if(arr[mid]<=arr[high]){
                high = mid -1 ;
            }
        }

        return -1;

    }
}
