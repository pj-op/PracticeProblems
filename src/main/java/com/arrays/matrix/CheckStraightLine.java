package com.arrays.matrix;

public class CheckStraightLine {
    public static void main(String[] args) {
        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println(checkStraightLine(coordinates));
    }

    public static boolean checkStraightLine(int[][] coordinates) {

        int deltaX = deltaX(coordinates[1], coordinates[0]);
        int deltaY = deltaY(coordinates[1], coordinates[0]);

        for (int i = 2; i < coordinates.length; i++) {
            if (deltaX * deltaX(coordinates[i], coordinates[0]) != deltaY * deltaY(coordinates[i], coordinates[0])) {
                return false;
            }
        }
        return true;
    }

    private static int deltaY(int[] a, int[] b) {
        return a[1] - b[1];
    }

    private static int deltaX(int[] a, int[] b) {
        return a[0] - b[0];
    }
}
