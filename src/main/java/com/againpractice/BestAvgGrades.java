package com.againpractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BestAvgGrades {

	public static void main(String[] args) {
		String studentRecord[][] = { { "Bobby", "87" }, { "Charles", "100" }, { "Eric", "64" }, { "Charles", "22" } };

		getBestAvgOfStudentRecord(studentRecord);
	}

	private static void getBestAvgOfStudentRecord(String[][] studentRecord) {

		HashMap<String, List<Integer>> studentGradesMap = new HashMap<>();
		List<Integer> gradesList = new ArrayList<>();

		for (int i = 0; i < studentRecord.length; i++) {

			String studentName = studentRecord[i][0];
			Integer grade = Integer.valueOf(studentRecord[i][1]);

			if (studentGradesMap.containsKey(studentName)) {
				gradesList = studentGradesMap.get(studentName);
				gradesList.add(grade);
				studentGradesMap.put(studentName, gradesList);
			} else {
				List<Integer> grades = new ArrayList<>();
				grades.add(grade);
				studentGradesMap.put(studentName, grades);
			}

		}

//		System.out.println(studentGradesMap);
		System.out.println(getHighestAvg(studentGradesMap));

	}

	public static double getHighestAvg(Map<String, List<Integer>> dataMap) {

		double highestAvg = 0.0;
		double currentAvg = 0.0;

		for (Entry<String, List<Integer>> items : dataMap.entrySet()) {
			currentAvg = calculateAvg(items.getValue());
			highestAvg = Math.max(highestAvg, currentAvg);
		}

		return highestAvg;
	}

	public static double calculateAvg(List<Integer> gradeList) {

		double avg = 0.0;
		double sum = 0;

		for (Integer grade : gradeList) {
			sum += grade;
		}

		avg = sum / gradeList.size();

		return avg;
	}

}
