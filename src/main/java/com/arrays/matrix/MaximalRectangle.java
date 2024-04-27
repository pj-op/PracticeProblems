package com.arrays.matrix;

import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(matrix));
    }

    private static int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        int[] height = new int[m];

        for (int i = 0; i < m; i++) {
            height[i] = matrix[0][i] - '0';
        }

        maxArea = findMaxArea(height);

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (matrix[row][col] == '0') {
                    height[col] = 0;
                } else {
                    height[col] += 1;
                }
            }
            maxArea = Math.max(maxArea, findMaxArea(height));
        }
        return maxArea;
    }

    private static int findMaxArea(int[] height) {
        int n = height.length;
        int[] width = new int[n];
        int area = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            width[i] = getNextSmallerToRight(height)[i] - getNextSmallerToLeft(height)[i] - 1;
        }

        for (int i = 0; i < n; i++) {
            int a = width[i] * height[i];
            area = Math.max(area, a);
        }
        return area;
    }

    private static int[] getNextSmallerToRight(int[] height) {
        int n = height.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ans[i] = n;
            } else {
                while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    ans[i] = n;
                } else {
                    ans[i] = stack.peek();
                }
            }
            stack.add(i);
        }
        return ans;
    }

    private static int[] getNextSmallerToLeft(int[] height) {
        int n = height.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    ans[i] = -1;
                } else {
                    ans[i] = stack.peek();
                }
            }
            stack.add(i);
        }
        return ans;
    }
}
