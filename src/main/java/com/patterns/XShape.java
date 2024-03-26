package com.patterns;

public class XShape {
    public static void main(String[] args) {
        printPattern(20);
    }

    public static void printPattern(int n) {
        int space = n;
        int divide = n / 2;
        boolean flag = false;
        int gap = space + (space / 2);

        for (int i = 1; i <= n; i++) {
            if (!flag) {
                if (i == divide) flag = true;
                for (int j = 1; j <= i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j < i + 1; j++) {
                    System.out.print("#");
                }
                for (int j = 1; j <= gap; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= i; j++) {
                    System.out.print("#");
                }
                gap -= 4;
            }

            if (i == divide) {
                System.out.println();
                space = 0;
            }

            if (flag) {
                for (int j = n - i; j > 0; j--) {
                    System.out.print(" ");
                }
                for (int j = n - i; j >= 1; j--) {
                    System.out.print("#");
                }
                for (int j = 0; j < space; j++) {
                    System.out.print(" ");
                }
                for (int j = n - i; j >= 1; j--) {
                    System.out.print("#");
                }
                space += 4;
            }
            System.out.println();
        }
    }
}