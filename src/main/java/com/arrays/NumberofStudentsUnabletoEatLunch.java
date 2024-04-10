package com.arrays;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberofStudentsUnabletoEatLunch {
    public static void main(String[] args) {
        int[] students = {1, 1, 1, 0, 0, 1};
        int[] sandwiches = {1, 0, 0, 0, 1, 1};
        System.out.println(countStudents(students, sandwiches));
    }

    private static int countStudents(int[] students, int[] sandwiches) {

        int student_0 = 0;
        int student_1 = 0;

        for (int student : students) {
            if (student == 0) student_0++;
            else student_1++;
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0 && student_0 > 0) {
                student_0--;
            } else if (sandwich == 1 && student_1 > 0) {
                student_1--;
            } else {
                break;
            }
        }
        return student_0 + student_1;
    }
}
