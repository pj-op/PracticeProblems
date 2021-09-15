package com.gs;

import java.util.*;

public class Miscellaneous {
    public static void main(String[] args) {
//        1. Count Length Of Cycle
        int arr[] = {0, 1, 2};
        int startIndex = 0;
//        System.out.println(countLengthOfCycle(arr, startIndex));

//        2. Magic Potion
        String stringToBeCompressed = "ABCABCE";
//        System.out.println(findMagicPotion(stringToBeCompressed));

//        3.Pascals Triangle
        int row = 8, col = 4, height = Math.max(row, col) + 1;
//        System.out.println(drawPascalTriangle(row, col, height));

//        4. Unique Tuples
        String tupleString = "abbccde";
        int length = 2;
//        System.out.println(getSetOfUniqueTuples(tupleString, length));

//        5. Best Average Grade
        String studentMarks[][] = {{"Bobby", "87"},
                {"Charles", "100"},
                {"Charles", "22"},
                {"Eric", "64"}};
//        System.out.println(getBestAvgGrade(studentMarks));

//        6. Snowpack
        int[] towers = {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0};
//        System.out.println(getTotalUnitsOfSnow(towers));
//        System.out.println(getTotalUnitsWithOptimal(towers));

    }

    private static int getTotalUnitsWithOptimal(int[] arr) {
        int left = 0, right = arr.length - 1, total = 0, maxLeft = 0, maxRight = 0;

        while (left < right) {
            if (arr[left] < arr[right]) {
                maxLeft = Math.max(maxLeft, arr[left]);
                total = total + maxLeft - arr[left];
                left++;
            } else {
                maxRight = Math.max(maxRight, arr[right]);
                total = total + maxRight - arr[right];
                right--;
            }
        }
        return total;
    }

    private static int getTotalUnitsOfSnow(int[] towers) {
        int left[] = new int[towers.length];
        int right[] = new int[towers.length];
        int totalUnit = 0;

        left[0] = towers[0];
        System.out.println("Left: " + left[0]);
        for (int i = 1; i < left.length; i++) {
            left[i] = Math.max(towers[i], left[i - 1]);
//            System.out.println(left[i]+" "+towers[i-1]);
        }
        System.out.println(Arrays.toString(left));

        right[towers.length - 1] = towers[towers.length - 1];
        for (int i = towers.length - 2; i >= 0; i--) {
            right[i] = Math.max(towers[i], right[i + 1]);
        }
        System.out.println(Arrays.toString(right));

        for (int i = 0; i < towers.length; i++) {
            totalUnit += Math.min(left[i], right[i]) - towers[i];
        }

        return totalUnit;
    }

    private static double getBestAvgGrade(String[][] studentMarks) {
        Map<String, List<Integer>> studentMarksMap = new HashMap<>();
        List<Integer> marksList = new ArrayList<>();

        for (int i = 0; i < studentMarks.length; i++) {
            String name = studentMarks[i][0];
            Integer marks = Integer.valueOf(studentMarks[i][1]);

            if (studentMarksMap.containsKey(name)) {
                marksList = studentMarksMap.get(name);
                marksList.add(marks);
                studentMarksMap.put(name, marksList);
            } else {
                List<Integer> newMarks = new ArrayList<>();
                newMarks.add(marks);
                studentMarksMap.put(name, newMarks);
            }
        }

        System.out.println(studentMarksMap);

        return getHighestAvg(studentMarksMap);
    }

    private static double getHighestAvg(Map<String, List<Integer>> map) {
        double highestAvg = 0;

        for (Map.Entry<String, List<Integer>> m : map.entrySet()) {
            highestAvg = Math.max(highestAvg, getAvgOfList(m.getValue()));
        }

        return highestAvg;
    }

    private static double getAvgOfList(List<Integer> value) {

        return value.stream().reduce((a, b) -> a + b).get() / value.size();
    }

    private static Set<String> getSetOfUniqueTuples(String tupleString, int length) {
        Set<String> s = new HashSet<>();
        for (int i = 0; i < tupleString.length() - 1; i++) {
            s.add(tupleString.substring(i, i + length));
        }
        return s;
    }

    private static int drawPascalTriangle(int row, int col, int height) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        List<Integer> a1 = new ArrayList<>();

        a1.add(1);
        pascalTriangle.add(a1);

        for (int i = 1; i <= height; i++) {
            List<Integer> a2 = pascalTriangle.get(i - 1);
            List<Integer> a3 = new ArrayList<>();

            a3.add(1);
            for (int j = 1; j < i; j++) {
                a3.add(a2.get(j - 1) + a2.get(j));
            }
            a3.add(1);

            pascalTriangle.add(a3);
        }

        pascalTriangle.stream().forEach(System.out::println);

        return pascalTriangle.get(row).get(col);
    }

    private static String findMagicPotion(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 1;

        sb.append(str.charAt(0));
        while (i < str.length()) {
            if (2 * i < str.length() && str.charAt(i) == str.charAt(0)) {
                if (str.substring(0, i).equals(str.substring(i, 2 * i))) {
                    sb.append("*");
                    i = 2 * i - 1;
                } else {
                    sb.append(str.charAt(i));
                }
            } else {
                sb.append(str.charAt(i));
            }
            i++;
        }

        return sb.toString();

    }

    private static int countLengthOfCycle(int[] arr, int startIndex) {
        int result[] = new int[arr.length];
        int index = startIndex;
        int count = 0;

        while (result[index] == 0) {
            result[index] = ++count;
            index = arr[index];
        }
        System.out.println(Arrays.toString(result));
        System.out.println("Count: " + count);

        return count - arr[index] + 1;

    }
}
