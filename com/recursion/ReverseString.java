package com.recursion;

import java.lang.reflect.Array;
import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = "ReverseString";
//        System.out.println(reverseString(s));

        int[][] moves = {{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}};
//        System.out.println(tictactoe(moves));

        int num = 5;
//        System.out.println(findSquareRoot(num));

//        Trash Bins
        /*System.out.print("Enter Number of test cases: ");
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            System.out.print("Enter Number of houses: ");
            int noOfHouses = scanner.nextInt();
            int houses[] = new int[noOfHouses];
            for (int j = 0; j < houses.length; j++) {
                houses[j] = scanner.nextInt();
            }

//            System.out.println(sumOfDistances(houses, noOfHouses));
//            System.out.println(sumOfDistancesII(houses, noOfHouses));
        }*/
//        System.out.println(trash(6, "100100"));

//        Max Consecutive Ones
        int nums[] = {1, 1, 0, 0, 0, 0, 0, 1, 1, 1};
//        System.out.println(findMaxConsecutiveOnes(nums));

        String str = "aabbcca";
//        System.out.println(encodeString(str));

//        Spiral Matrix
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
//        System.out.println(Arrays.toString(printSpiralMatrix(arr)));

//        Zig zag
        int n = 2;
//        printZigZagSeries(n);


//        Print Zig zag String(Yet to complete)
        String s1 = "PAYPALISHIRING";
        int noOfRows = 3;
//        System.out.println(printZigZagString(s1, noOfRows));

//        Maximum Length of a Concatenated String with Unique Characters
        List<String> strings = Arrays.asList("un", "iq", "ue");
//        System.out.println(maxLength(strings));
//        System.out.println(maxLengthII(strings));

//        Search in Rotated Sorted Array
        int[] numsArr = {3, 1};
        int target = 1;
//        System.out.println(search(numsArr, target)); //O(n) solution
//        System.out.println(searchOptimal(numsArr, target));  // O(log n) solution

        String palindrome = "aba";
        System.out.println(breakPalindrome(palindrome));

        scanner.close();
    }

    private static String breakPalindrome(String palindrome) {
        int count = 0;
        String result = null;
        if (palindrome.length() < 2) return "";

        char[] str = palindrome.toCharArray();

        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (str[i] != 'a') {
                str[i] = 'a';
                break;
            } else count++;
        }

        if (count == (str.length / 2)) {
            str[str.length - 1] = 'b';
        }

//        result = count == str.length / 2 ? String.valueOf(str[str.length - 1] = 'b') : String.valueOf(str);

        return String.valueOf(str);

//        return null;
    }

    private static int searchOptimal(int[] numsArr, int target) {

        int low = 0, high = numsArr.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;

            if (numsArr[mid] == target) return mid;

            if (numsArr[mid] >= numsArr[low]) {
                if (numsArr[mid] > target && numsArr[low] <= target) {
                    high = mid - 1;
                } else low = mid + 1;
            } else if (numsArr[mid] <= numsArr[high]) {
                if (numsArr[mid] < target && numsArr[high] >= target) {
                    low = mid + 1;
                } else high = mid - 1;
            } else return -1;
        }
        return -1;
    }

    private static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            if (nums[low] == target) return low;
            else if (nums[high] == target) return high;
            else {
                low++;
                high--;
            }
        }
        return -1;
    }

    private static int maxLengthII(List<String> strings) {
        int maxLength = 0;
        List<String> res = new ArrayList<>();
        res.add("");

        for (String word : strings) {
            int resLength = res.size();
            for (int i = 0; i < resLength; i++) {
                String newRes = res.get(i) + word;
                Set<Character> s = new HashSet<>();
                for (Character c : newRes.toCharArray()) {
                    s.add(c);
                }
                if (newRes.length() != s.size()) {
                    continue;
                }

                res.add(newRes);
                maxLength = Math.max(maxLength, newRes.length());
            }
        }

        System.out.println("List: " + res);

        return maxLength;
    }

    private static int maxLength(List<String> arr) {
        int result[] = new int[1];

        maxUnique(arr, 0, "", result);

        return result[0];
    }

    private static void maxUnique(List<String> arr, int index, String currString, int[] result) {
        if (index == arr.size() && uniqueCharCount(currString) > result[0]) {
            result[0] = currString.length();
            return;
        }
        if (index == arr.size()) return;

        maxUnique(arr, index + 1, currString, result);
        maxUnique(arr, index + 1, currString + arr.get(index), result);

    }

    private static int uniqueCharCount(String currString) {
        int charCount[] = new int[26];
        for (char c : currString.toCharArray()) {
            if (charCount[c - 'a']++ > 0) {
                return -1;
            }
        }

        return currString.length();
    }

    private static String printZigZagString(String s1, int noOfRows) {
        StringBuilder sb = new StringBuilder();

        int flRow = (noOfRows - 1) * 2;

        for (int i = 0; (i * flRow) < s1.length(); i++) {
            sb.append(s1.charAt(i * flRow));
        }


        return sb.toString();
    }

    private static void printZigZagSeries(int n) {
        if (n == 0) return;

        System.out.println("Pre: " + n + " ");
        printZigZagSeries(n - 1);
        System.out.println("In: " + n + " ");
        printZigZagSeries(n - 1);
        System.out.println("Post: " + n + " ");
    }

    private static int[] printSpiralMatrix(int[][] arr) {
        int[] spiral = new int[arr.length * arr[0].length];
        int minCol = 0, minRow = 0, maxRow = arr.length - 1, maxCol = arr[0].length - 1;
        int index = 0;
        while (index < spiral.length) {
            for (int i = minCol; i <= maxCol && index < spiral.length; i++) {
                spiral[index] = arr[minRow][i];
                index++;
            }
            minRow++;
            for (int i = minRow; i <= maxRow && index < spiral.length; i++) {
                spiral[index] = arr[i][maxCol];
                index++;
            }
            maxCol--;
            for (int i = maxCol; i >= minCol && index < spiral.length; i--) {
                spiral[index] = arr[maxRow][i];
                index++;
            }
            maxRow--;
            for (int i = maxRow; i >= minRow && index < spiral.length; i--) {
                spiral[index] = arr[i][minCol];
                index++;
            }
            minCol++;
        }

        return spiral;
    }

    private static String encodeString(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        while (i < str.length()) {
            sb.append(str.charAt(i));
            while (j < str.length() && str.charAt(i) == str.charAt(j)) {
                j++;
            }
            int diff = j - i;
            sb.append(diff);
            i = j;
        }


        return sb.toString();
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int i = 0, j = 0;

        while (i < nums.length) {
            if (nums[i] == 1) {
                while (j < nums.length && nums[i] == nums[j]) {
                    j++;
                }
                int diff = j - i;
                result = Math.max(result, diff);
                i = j;
            } else {
                i++;
                j++;
            }
        }
        return result;
    }

    private static long trash(int n, String s) {
        Scanner sc = new Scanner(System.in);

        int left[] = new int[n];
        int right[] = new int[n];

        int x = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') x = i;
            left[i] = x;
        }
        System.out.println(Arrays.toString(left));

        int y = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') y = i;
            right[i] = y;
        }
        System.out.println(Arrays.toString(right));

        long total = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] < 0) total += right[i] - i;
            else
                total += Math.min(right[i] - i, i - left[i]);
        }


        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        return total;
    }

    private static double findSquareRoot(int num) {
        double temp = 0;
        double sr = num / 2;

        do {
            temp = sr;
            sr = (temp + num / temp) / 2;
        } while (temp - sr != 0);


        return sr;
    }

    private static String tictactoe(int[][] moves) {

        char filledArray[][] = fillArray(moves);
        int rowA = 0, rowB = 0;
        int colA = 0, colB = 0;

        // Row counts
        for (int i = 0; i < filledArray.length; i++) {
            for (int j = 0; j < filledArray[i].length; j++) {
                if (filledArray[i][j] == 'X') rowA++;
                else if (filledArray[i][j] == '-') rowB++;
            }
            if (rowA == 3) return "A";
            else if (rowB == 3) return "B";
        }

        // Column counts
        for (int i = 0; i < filledArray.length; i++) {
            for (int j = 0; j < filledArray[i].length; j++) {
                if (filledArray[j][i] == 'X') colA++;
                else if (filledArray[j][i] == '-') colB++;
            }
            if (colA == 3) return "A";
            else if (colA == 3) return "B";
        }

        // Diagonal Counts
        if (filledArray[0][0] == 'X' && filledArray[1][1] == 'X' && filledArray[2][2] == 'X') return "A";
        else if (filledArray[0][0] == '0' && filledArray[1][1] == '0' && filledArray[2][2] == '0') return "B";

        // other way diagonal
        if (filledArray[2][0] == 'X' && filledArray[1][1] == 'X' && filledArray[0][2] == 'X') return "A";
        else if (filledArray[2][0] == '0' && filledArray[1][1] == '0' && filledArray[0][2] == '0') return "B";

        int count = 0;
        for (int i = 0; i < filledArray.length; i++) {
            for (int j = 0; j < filledArray[i].length; j++) {
                count++;
            }
        }

        if (count != 9) return "Pending";

        return "Draw";
    }

    private static char[][] fillArray(int[][] moves) {
        char[][] inputs = new char[3][3];
        // Filling all places with "."
        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < inputs[i].length; j++) {
                inputs[i][j] = '.';
            }
        }
        System.out.println("Before: " + Arrays.deepToString(inputs));

        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) inputs[moves[i][0]][moves[i][1]] = 'X';
            else inputs[moves[i][0]][moves[i][1]] = '0';
        }
        System.out.println("After: " + Arrays.deepToString(inputs));
        return inputs;
    }

    private static String reverseString(String s) {

        if (s != null && s.length() <= 1) return s;
        return reverseString(s.substring(1)) + s.charAt(0);
    }
}
