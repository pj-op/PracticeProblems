package com.strings;

public class LargestSubstringBetweenTwoEqualCharacters {
    public static void main(String[] args) {
        String s = "abac";
        System.out.println(maxLengthBetweenEqualCharacters(s));
    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();
        int left = 0;
        int ans = -1;
        int right = n - 1;

        while (left < right) {
            while (right >= 0) {
                if (s.charAt(left) == s.charAt(right)) {
                    ans = Math.max(ans, right - left);
                }
                right--;
            }
            right = n - 1;
            left++;
        }
        return ans - 1;
    }
}
