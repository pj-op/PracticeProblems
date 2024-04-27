package com.weeknd;

import java.util.*;
import java.util.stream.Collectors;

public class BestAvgGrades {

    public static void main(String[] args) {
        String[][] studentArr = {{"Bob", "87"}, {"Mike", "55"}, {"Bob", "52"}, {"Jason", "35"},
                {"Mike", "155"}, {"Jessica", "99"}};
//		calculateBestAvgGrades(studentArr);
        calculateBestAvgGradesAgainI(studentArr);
    }

    private static void calculateBestAvgGradesAgainI(String[][] studentArr) {

        Arrays.stream(studentArr)
                .sorted((a, b) -> Integer.compare(Integer.parseInt(b[1]), Integer.parseInt(a[1])))
                .forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    private static void calculateBestAvgGradesAgain(String[][] studentArr) {
        Map<String, Integer> data = new HashMap<>();
        data = Arrays.stream(studentArr).collect(Collectors.toMap(a -> a[0], a -> Integer.valueOf(a[1]), Integer::sum));
        System.out.println(data);

        var collect = Arrays.stream(studentArr).collect(Collectors.groupingBy(a -> a[0], Collectors.mapping(a -> Integer.valueOf(a[1]), Collectors.toList())));
        System.out.println(collect);

    }

    public static void calculateBestAvgGrades(String[][] studentGrades) {

        HashMap<String, List<Integer>> studentNameWithMarks = new HashMap<>();
        List<Integer> grades = new ArrayList<>();

        for (int i = 0; i < studentGrades.length; i++) {
            int grade = Integer.valueOf(studentGrades[i][1]);
            String studenName = studentGrades[i][0];

            if (studentNameWithMarks.containsKey(studenName)) {
                grades = studentNameWithMarks.get(studenName);
                grades.add(grade);
            } else {
                List<Integer> newStudentMarks = new ArrayList<>();
                newStudentMarks.add(grade);
                studentNameWithMarks.put(studenName, newStudentMarks);
            }
        }

        System.out.println(studentNameWithMarks);

    }

}

class PairAvg {
    int count;
    int total;
}